package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Main page")
@Tag("web")
public class MainPageTests {
    @Test
    void logoShouldBeVisible() {
        open("https://bell-sw.com/");

        $(".l-liberica")
                .$(byTitle("Liberica JDK, Committed to Freedom, 100% OpenJDK based, TCK verified"))
                .shouldBe(visible);
    }

    @Test
    void downloadsBlockShouldHaveContent() {
        open("https://bell-sw.com/");

        $(".l-liberica-downloads").$$(".l-liberica-download").shouldHaveSize(3);
        $(".l-liberica-download").shouldHave(text("LTS versions"), text("(long-term support)"));
        $(".l-liberica-download", 1).shouldHave(text("Current release"));
        $(".l-liberica-download", 2).shouldHave(text("LTS versions for Embedded"));
    }

    @Test
    void benefitsBlockShouldHaveContent() {
        open("https://bell-sw.com/");

        $(".l-benefits").$$(".l-benefit").shouldHaveSize(4);
        $(".l-benefit").shouldHave(text("Java SE standard compliance"),
                text("Each binary is verified by Technology Compatibility Kit " +
                        "which guarantees 100% compatibility with Java SE specification"));
        // todo for .l-benefit 2, 3, 4
    }

}
