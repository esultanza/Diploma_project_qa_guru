package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("QA.GURU Diploma project")
@Tag("web")
public class CarVideoTests extends TestBase {
    @Test
    @Feature("Option tests")
    @Description("Checking capability to switch watching modes")
    @DisplayName("Switch modes")
    void switchModesTest() {
        step("Open web-site with traveling by car video", () ->
                open("/"));
        step("Change video speed", () -> {
//            <div id="active" class="Button Rates col"> 2x </div>
            $(".rowCol.right.col-lg>div>li:nth-child(3)").click();
            $("#active.Button.Rates.col").shouldHave(text("2"));
        });
        step("Change Radio station", () -> {
            $(".radioPlayer.next.col-sm-2.col-2").click();
            $(".radioPlayer.pause.col-sm-2").shouldBe(visible);

        });
    }

    @Test
    @Feature("Option tests")
    @Description("Checking capability to change city")
    @DisplayName("Change city")
    void changeCityTest() {
        step("Open web-site with traveling by car video", () ->
                open("/"));

        step("Change city video streaming", () -> {
            $(byText("Lauterbrunnen")).click();
            $(byText("Lauterbrunnen, Switzerland")).shouldHave(id("active"));
        });

    }

    @Test
    @Feature("Option tests")
    @Description("Checking capability to turn off street noise, radio, hide right bar. " +
            "And then just to take a pleasure from undiscovered road")
    @DisplayName("Occam")
    void occamTest() {
        step("Open web-site with traveling by car video", () ->
                open("/"));

        step("Verify, irritants could be turn off", () -> {
            step("turn off street noise", () ->
                $(".Button.rowCol.right.no-right-margin.col-lg").shouldBe(visible).doubleClick());
            step("turn off radio", () ->
                $(".radioPlayer.play.col-sm-2").shouldBe(visible).doubleClick());
            step("hide right bar", () -> {
                $("p.layer").click();
                $("#panel").shouldNotBe(visible);
            });
        });
    }

    @Test
    @Feature("Outside tests")
    @Description("Make sure project is alive by visiting its instagram")
    @DisplayName("It's alive")
    void aliveTest() {
        step("Open web-site with traveling by car video", () ->
                open("/"));

        step("Verify, instagram link is available", () ->
                $(byText("Follow me!")).shouldBe(visible).click());
        step("Verify, instagram account has a link to the project", () -> {
                switchTo().window(1);
                $(byText("driveandlisten.herokuapp.com")).shouldBe(visible);});
        };

    @Test
    @Feature("Outside tests")
    @Description("Make sure video is fresh")
    @DisplayName("Actual video")
    void actualVideoTest() {
        step("Open web-site with traveling by car video", () ->
                open("/"));

        step("Verify, YouTube link is available", () ->
                $(byText("Video source")).shouldBe(visible).click());
        step("Verify, streaming video is not older than 2018", () -> {
            switchTo().window(1);
            $("#date.style-scope.ytd-video-primary-info-renderer").shouldHave(Condition.matchText("^.*?(201[8-9]).*?$|^*(202[0-2])*$"));});
    };
}
