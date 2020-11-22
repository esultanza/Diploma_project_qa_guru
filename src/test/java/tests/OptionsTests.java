package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.openqa.selenium.Keys;

@Epic("QA.GURU Diploma project")
@Tag("web")
public class OptionsTests extends TestBase {
    @Test
    @Description("Checking capability to switch watching modes")
    @DisplayName("Switch modes")
    void switchModes() {
        step("Open web-site with traveling by car video", () ->
                open("/"));
//*[@id="active"]/text()[2]
        step("Change video speed", () -> {
            $(".li", 2).click();
            $(".li", 2).shouldHave(id("active"));
        });
        step("Change Radio station", () -> {
            $(byClassName("radioPlayer next col-sm-2 col-2")).click();
            $(byClassName("radioPlayer pause col-sm-2")).shouldBe(visible);

        });
    }

    @Test
    @Description("Checking capability to change city")
    @DisplayName("Change city")
    void changeCity() {
        step("Open web-site with traveling by car video", () ->
                open("/"));

        step("Change city video streaming", () -> {
            $(byText("Los Angeles, USA")).click();
            $(byText("Los Angeles, USA")).shouldHave(id("active"));
        });

    }
}
