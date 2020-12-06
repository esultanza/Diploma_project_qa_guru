package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.AllureId;
import static io.qameta.allure.Allure.step;

@Feature("QA.GURU Diploma project")
@Tag("web")
public class CarVideoTests extends TestBase {
    @Test
    @Story("Option tests")
    @Description("Checking capability to switch watching and acoustic modes")
    @DisplayName("Switch modes")
    void switchModesTest() {
        step("Open web-site with traveling by car video", () -> open("/"));
        step("Change video speed", () -> {
            $(".rowCol.right.col-lg>div>li:nth-child(3)").click();
            $("#active.Button.Rates.col").shouldHave(text("2"));
        });
        step("Change radio station", () -> {
            $(".radioPlayer.next.col-sm-2.col-2").click();
            $(".radioPlayer.pause.col-sm-2").shouldBe(visible);
        });
    }

    @Test
    @Story("Option tests")
    @Description("Checking capability to change city")
    @DisplayName("Change city")
    void changeCityTest() {
        step("Open web-site with traveling by car video", () -> open("/"));
        step("Change city video streaming", () -> {
            $(byText("Lauterbrunnen")).click();
            $(byText("Lauterbrunnen, Switzerland")).shouldHave(id("active"));
        });
    }

    @Test
    @Story("Option tests")
    @Description("Checking capability to turn off street noise, radio, hide right bar. " +
            "And then just to take a pleasure from undiscovered roads")
    @DisplayName("Occam")
    void occamTest() {
        step("Open web-site with traveling by car video", () -> open("/"));
        step("Verify, irritants could be turned off", () -> {
            step("Turn off street noise", () ->
                    $(".Button.rowCol.right.no-right-margin.col-lg").shouldBe(visible).doubleClick());
            step("Turn off radio", () ->
                    $(".radioPlayer.play.col-sm-2").shouldBe(visible).doubleClick());
            step("Hide right bar", () -> {
                $("p.layer").click();
                $("#panel").shouldNotBe(visible);
            });
        });
    }

    @Test
    @AllureId("1464")
    @Story("Outside the portal tests")
    @Description("Make sure video is fresh")
    @DisplayName("Actual video")
    void actualVideoTest() {
        step("Open web-site with traveling by car video", () -> open("/"));
        step("Verify, YouTube link is available", () ->
                $(byText("Video source")).shouldBe(visible).click());
        step("Verify, streaming video is not older than 2018", () -> {
            switchTo().window(1);
            $("#date.style-scope.ytd-video-primary-info-renderer").shouldHave(Condition.matchText("^.*?(201[8-9]).*?$|^*(202[0-2])*$"));
        });
    }
    
    @Test
    @Story("Outside the portal tests")
    @Description("Make sure project is alive by visiting its instagram")
    @DisplayName("It's alive")
    void aliveTest() {
        step("Open web-site with traveling by car video", () -> open("/"));
        step("Verify, instagram link is available", () ->
                $(byText("Follow me!")).shouldBe(visible).click());
        step("Verify, instagram account has a link to the project", () -> {
            switchTo().window(1);
            $(byText("driveandlisten.herokuapp.com")).shouldBe(visible);
        });
    }
}
