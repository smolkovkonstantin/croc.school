package ru.croc.task9.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 extends Hasher {

    private String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    @Override
    public byte[] hashPassword(byte[] byteSequence) {
        String result = null;

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(byteSequence);
        return md.digest();
    }

    public String hashPasswordString(byte[] stringBytes) {
        return toHexString(hashPassword(stringBytes));
    }
}
