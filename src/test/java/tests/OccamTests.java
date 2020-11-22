package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.openqa.selenium.Keys;

@Epic("QA.GURU Diploma project")
@Tag("web")
public class OccamTests extends TestBase {
    @Test
    @Description("Checking capability to turn off street noise, radio, hide right bar, close rewards pop-up, " +
            "expand to full screen. And then just to take a pleasure from undiscovered road")
    @DisplayName("Turn off irritants")
    void remodeIrritants() {
        step("Open web-site with traveling by car video", () ->
                open("http://driveandlisten.herokuapp.com/"));

        step("Verify, irritants could be turn off", () -> {
                $(byClassName("Button rowCol right no-right-margin col-lg")).shouldBe(visible).doubleClick();
                $(byClassName("radioPlayer play col-sm-2")).shouldBe(visible).doubleClick();
                $(byText("Show")).click();
                $(byClassName("video-stream html5-main-video")).sendKeys(Keys.F11);
                $(byText("×")).waitUntil(visible, 110000).click();
        });
    }
}

