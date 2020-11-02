package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Contact form")
@Tag("web")
public class ContactFormTests {
    @Test
    void contactFormShouldAppearByButton() {
        open("https://bell-sw.com/");

        $(by("data-target", "#popup-contact-form-window")).click();

        $("#popup-contact-form-window").$(".modal-content").shouldHave(text("Want to Know More? Contact Us!"));
    }
}
