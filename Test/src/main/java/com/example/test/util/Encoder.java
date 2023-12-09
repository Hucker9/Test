package com.example.test.util;

import org.springframework.security.crypto.password.PasswordEncoder;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(rawPassword.toString().getBytes());
            byte[] messageDigest = digest.digest();
            StringBuilder haxString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                StringBuilder h = new StringBuilder(Integer.toHexString(0xFF & aMessageDigest));
                while (h.length() < 2) {
                    h.insert(0, "0");
                }
                haxString.append(h);
            }
            return haxString.toString();
        } catch (NoSuchAlgorithmException e) {

            return null;
        }
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return new Encoder().encode(charSequence).equals(s);
    }
}
