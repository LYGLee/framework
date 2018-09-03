package com.liyuan.zero.framework.util;


import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 编码与解码操作工具类
 * Created by liyuan on 2018/9/1
 */
public final class CodecUtil {

    private CodecUtil(){}

    private static final Logger log = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将 URL 编码
     */
    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (Exception e) {
            log.error("encode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将 URL 解码
     */
    public static String decodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (Exception e) {
            log.error("decode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * MD5 加密
     */
    public static String md5(String source) {
        return DigestUtils.md5Hex(source);
    }
}
