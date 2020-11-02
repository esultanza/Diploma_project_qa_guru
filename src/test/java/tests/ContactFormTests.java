package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Contact form")
@Tag("web")
public class ContactFormTests extends TestBase {
    @Test
    @DisplayName("Contact form should appear when click on CONTACT US button")
    void contactFormShouldAppearByButton() {
        step("Open main page", () ->
                open("/"));

        step("Click on CONTACT US button", () ->
                $(by("data-target", "#popup-contact-form-window")).click());

        step("Verify, contact modal appears", () ->
                $("#popup-contact-form-window").$(".modal-content").shouldHave(text("Want to Know More? Contact Us!")));
    }
}
