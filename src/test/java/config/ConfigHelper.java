package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getPlatform() {
        return System.getProperty("platform", "web");
    }

    public static Boolean isWeb() {
        return getPlatform().equals("web");
    }

    public static Boolean isAndroid() {
        return getPlatform().equals("android");
    }

    public static Boolean isIos() {
        return getPlatform().equals("ios");
    }

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static String getWebBrowser() {
        return getWebConfig().webBrowser();
    }

    public static String getWebRemoteDriver() {
        return getWebConfig().webRemoteDriver();
    }

    public static String getWebVideoStorage() {
        return getWebConfig().webVideoStorage();
    }

    private static WebConfig getWebConfig() {
        if (System.getProperty("environment") == null) System.setProperty("environment", "prod"); // stage, preprod

        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

//    public static String getAndroidApp() {
//        return getAndroidConfig().webUrl();
//    }
//
//    private static WebConfig getAndroidConfig() {
//        return ConfigFactory.newInstance().create(AndroidConfig.class, System.getProperties());
//    }
}
