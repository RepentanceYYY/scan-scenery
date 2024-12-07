package com.scene.utils;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class EncryptionTools {
    public String mD5ToString(String startStr) {
        return DigestUtils.md5Hex(startStr);
    }
}
