package ua.nure.teteruk.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHash {
    public String hash(String password) {
        return DigestUtils.md2Hex(password);
    }
}
