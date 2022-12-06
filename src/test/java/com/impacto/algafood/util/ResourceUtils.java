package com.impacto.algafood.util;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ResourceUtils {

    public static String getContentFromResource(String resourceName) {
        InputStream resourceAsStream = ResourceUtils.class.getResourceAsStream(resourceName);
        try {
            return StreamUtils.copyToString(resourceAsStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
