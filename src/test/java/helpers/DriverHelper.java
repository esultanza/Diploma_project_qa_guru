package helpers;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ConfigHelper;
import drivers.CustomMobileDriver;
import drivers.CustomWebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class DriverHelper {

    public static void configureSelenide() {
        if (ConfigHelper.isWeb()) {
            Configuration.browser = CustomWebDriver.class.getName();
            Configuration.baseUrl = ConfigHelper.getWebUrl();
        } else if (ConfigHelper.isAndroid() || ConfigHelper.isIos()) {
            Configuration.browser = CustomMobileDriver.class.getName();
            Configuration.startMaximized = false;
            Configuration.browserSize = null;
        }
        Configuration.timeout = 10000;
    }

    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }

//    public static String getNetworkLogs() {
//        todo https://ru.selenide.org/2019/12/18/advent-calendar-network-logs-with-proxy/
//    }

}