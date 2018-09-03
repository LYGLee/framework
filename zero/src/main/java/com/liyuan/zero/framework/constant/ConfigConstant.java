package com.liyuan.zero.framework.constant;

/**
 * 提供相关配置项常量
 * <p>
 * Created by liyuan on 2018/8/27
 */
public class ConfigConstant {
    private ConfigConstant() {
    }

    public static final String CONFIG_FILE = "zero.properties";

    public static final String JDBC_DRIVER = "zero.framework.jdbc.driver";
    public static final String JDBC_URL = "zero.framework.jdbc.url";
    public static final String JDBC_USERNAME = "zero.framework.jdbc.username";
    public static final String JDBC_PASSWORD = "zero.framework.jdbc.password";

    public static final String APP_BASE_PACKAGE = "zero.framework.app.base_package";
    public static final String APP_JSP_PATH = "zero.framework.app.jsp_path";
    public static final String APP_ASSET_PATH = "zero.framework.app.asset_path";
    public static final String APP_UPLOAD_LIMIT = "zero.framework.app.upload_limit";
}
