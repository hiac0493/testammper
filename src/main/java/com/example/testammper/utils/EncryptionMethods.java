package com.example.testammper.utils;

import com.example.testammper.exception.BelvoException;
import lombok.extern.slf4j.Slf4j;
import nl.flotsam.xeger.Xeger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class EncryptionMethods {
    @Autowired
    public EncryptionMethods(
            @Value("${iv}") String iv, @Value("${key}") String key) {
        this.iv = iv;
        this.key = key;
    }

    private String iv;
    private String key;

    public String encrypt(String valueToEncrypt) {
        try {
            byte[] contentByte = valueToEncrypt.getBytes(StandardCharsets.UTF_8);
            byte[] keyByte = key.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
            byte[] initParam = iv.getBytes();

            IvParameterSpec ivSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encryptedBytes = cipher.doFinal(contentByte);

            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new BelvoException(e.getMessage());
        }
    }

    public String decrypt(String content) {
        try {
            byte[] contentByte = Base64.getDecoder().decode(content);
            byte[] keyByte = key.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
            byte[] initParam = iv.getBytes();

            IvParameterSpec ivSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            return new String(cipher.doFinal(contentByte), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new BelvoException(e.getMessage());
        }

    }

    public String genMatchString(String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        Xeger generator;
        String str;
        do {
            generator = new Xeger(regex);
            str = generator.generate();
            str = str.length() > 5 ? str.substring(1, str.length() - 1) : "";
            matcher = pattern.matcher(str);
        } while (str == "" || !matcher.matches());
        return str;
    }

}
