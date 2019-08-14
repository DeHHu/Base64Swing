package com.company;

import com.sun.istack.internal.Nullable;

import java.util.Base64;

class EncoderDecoder {

    @Nullable
    static String encode(String rawString) {
        try {
            return Base64.getEncoder().encodeToString(rawString.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    static String decode(String rawString) {
        try {
            return new String(Base64.getDecoder().decode(rawString));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
