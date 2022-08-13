package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class automationPracticeForm {

    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.browserSize = "760x840";

    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Gendolf");
        $("#lastName").setValue("Gray");
        $("#userEmail").setValue("gendolf@mail.mr");
        $(".custom-control-label").click();
        $("#userNumber").setValue("9359659655");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--003").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/111.jpg"));
        $("#currentAddress").setValue("middle earth");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Gendolf Gray"),
                text("gendolf@mail.mr"),
                text("Male"),
                text("9359659655"),
                text("03 December,1988"),
                text("History"),
                text("Reading"),
                text("111.jpg"),
                text("middle earth"),
                text("Haryana Karnal"));



    }
}
