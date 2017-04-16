package com.quadirkareem.tryouts;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceLoader {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceLoader.class);

    public static String getContentUsingSystemClassLoader(String resource) throws IOException {
        LOG.info(resource + ": ");
        URL url = ClassLoader.getSystemResource(resource);
        getRealPath(url);
        String content = "";
        if (url != null) {
            InputStream is = ClassLoader.getSystemResourceAsStream(resource);
            content = IOUtils.toString(is);
        }
        return content;
    }

    public static String getContentUsingClass(String resource) throws IOException {
        LOG.info(resource + ": ");
        URL url = ResourceLoader.class.getResource(resource);
        getRealPath(url);
        String content = "";
        if (url != null) {
            InputStream is = ResourceLoader.class.getResourceAsStream(resource);
            content = IOUtils.toString(is);
        }
        return content;
    }

    public static String getContentUsingClassLoader(String resource) throws IOException {
        LOG.info(resource + ": ");
        URL url = ResourceLoader.class.getClassLoader().getResource(resource);
        getRealPath(url);
        String content = "";
        if (url != null) {
            InputStream is = ResourceLoader.class.getClassLoader().getResourceAsStream(resource);
            content = IOUtils.toString(is);
        }
        return content;
    }

    public static String getContentUsingClassLoader(ClassLoader classLoader, String resource) throws IOException {
        LOG.info(resource + ": ");
        URL url = classLoader.getResource(resource);
        getRealPath(url);
        String content = "";
        if (url != null) {
            InputStream is = classLoader.getResourceAsStream(resource);
            content = IOUtils.toString(is);
        }
        return content;
    }

    public static String getContentUsingContextClassLoader(String resource) throws IOException {
        LOG.info(resource + ": ");
        URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
        getRealPath(url);
        String content = "";
        if (url != null) {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            content = IOUtils.toString(is);
        }
        return content;
    }

    private static String getRealPath(URL url) {
        String realPath = null;
        if (url != null) {
            try {
                LOG.info("url = " + url);
                URI uri = url.toURI();
                LOG.info("uri = " + uri);
                realPath = Paths.get(url.toURI()).toString();
                LOG.info("path = " + realPath);
            }
            catch (Throwable e) {
                LOG.error("Error while getting real path for {}", url, e);
            }
        }
        return realPath;
    }

}
