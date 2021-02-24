package com.upperleaf.commons;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncodeUtils {

    private static Base64.Encoder encoder = Base64.getEncoder();

    static public String encodeUtf8(String s){
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    static public byte[] encodeBase64(String s){
        return encoder.encode(s.getBytes());
    }

}
