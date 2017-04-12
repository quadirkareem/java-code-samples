import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.apache.commons.lang3.text.StrSubstitutor;

final class SubstitutionInterceptor<T> implements MethodInterceptor {
	private final T underlying;
	private static StrSubstitutor substitutor;
	static {
		createSubstitutor();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T newInstance(Class<T> clazz, T obj) throws IOException {
		return (T) Enhancer.create(clazz, new SubstitutionInterceptor(obj));
	}

	public SubstitutionInterceptor(T underlying) {
		this.underlying = underlying;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		Object ret = method.invoke(underlying, args);
		if (ret != null) {// && method.getName().startsWith("get")) {
			return substitutor.replace(ret);
		}
		return ret;
	}

	private static void createSubstitutor() {
		substitutor = new StrSubstitutor(getGlobalEnv());
	}

	private static Map<String, String> getGlobalEnv() {
		Map<String, String> globalEnv = new HashMap<String, String>();
		globalEnv.putAll(System.getenv());
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Map<String, String> systemProperties = (Map) System.getProperties();
		globalEnv.putAll(systemProperties);
		return globalEnv;
	}

}