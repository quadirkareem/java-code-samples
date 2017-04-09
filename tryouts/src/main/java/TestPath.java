import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URISyntaxException;

public class TestPath {

	public static void main(String[] args) throws IOException, URISyntaxException {
       Path p = Paths.get(ClassLoader.getSystemResource(args[0]).toURI());
       System.out.println("File Path: " + p.toAbsolutePath());	
       String content = new String(Files.readAllBytes(p), StandardCharsets.UTF_8);
       System.out.println("\nContent:\n" + content);	
	
	}

}