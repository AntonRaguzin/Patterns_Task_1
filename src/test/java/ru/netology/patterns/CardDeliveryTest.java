package ru.netology.patterns;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
//        var validUser = DataGenerator.Registration.generateUser("ru");
        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);
        var locale = "ru";

        $("[data-test-id=city] input").setValue(DataGenerator.generateCity(locale));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(firstMeetingDate);
        $("[data-test-id=name] input").setValue(DataGenerator.generateName(locale));
        $("[data-test-id=phone] input").setValue(DataGenerator.generatePhone(locale));
        $("[data-test-id=agreement]").click();
        $(".button__text").click();
        $("[data-test-id=success-notification] [class=notification__content]")
                .shouldHave(exactText("Встреча успешно запланирована на " + firstMeetingDate))
                .shouldBe(visible);
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(secondMeetingDate);
        $(".button__text").click();
        $("[data-test-id=replan-notification] [class=notification__content]")
                .shouldHave(exactText("У вас уже запланирована встреча на другую дату. Перепланировать?"))
                .shouldBe(visible);
        $("[data-test-id=replan-notification] [role=button]").click();
        $("[data-test-id=success-notification] [class=notification__content]")
                .shouldHave(exactText("Встреча успешно запланирована на " + secondMeetingDate), Duration.ofSeconds(3))
                .shouldBe(visible);

        // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи.
        // Для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
        // firstMeetingDate и secondMeetingDate. Можно также вызывать методы generateCity(locale),
        // generateName(locale), generatePhone(locale) для генерации и получения в тесте соответственно города,
        // имени и номера телефона без создания пользователя в методе generateUser(String locale) в датагенераторе
    }
}



//    private static Faker faker;
//
//
//    @BeforeAll
//    static void SetUpAll() {
//        faker = new Faker(new Locale("ru"));
//    }
//
//    @BeforeEach
//    void setup() {
//        open("http://localhost:9999");
//
//    }
//
//    @Test
//    void ShoildGenerateTestDada(){
//        String name = faker.name().fullName();
////        String date = String.valueOf(faker.date().birthday(18, 20));
//        System.out.println(name);//printTestData(name, date);
//    }
////    @DisplayName("Should successful plan and replan meeting")
////    void shouldSuccessfulPlanAndReplanMeeting() {
////        var validUser = DataGenerator.Registration.generateUser("ru");
////        var daysToAddForFirstMeeting = 4;
////        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
////        var daysToAddForSecondMeeting = 7;
////        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);
//    // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи.
//    // Для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
//    // firstMeetingDate и secondMeetingDate. Можно также вызывать методы generateCity(locale),
//    // generateName(locale), generatePhone(locale) для генерации и получения в тесте соответственно города,
//    // имени и номера телефона без создания пользователя в методе generateUser(String locale) в датагенераторе
////    }
//
//    @Test
//
//    void ShouldGetNewDeliveryDate() {
//
//
////        Configuration.headless = true;
//        String date1 = LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        String date2 = LocalDate.now().plusDays(10).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//
//        $("[data-test-id=city] input").setValue("Москва");
//        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
//        $("[data-test-id=date] input").setValue(date1);
//        $("[data-test-id=name] input").setValue("Антон");
//        $("[data-test-id=phone] input").setValue("+79998887766");
//        $("[data-test-id=agreement]").click();
//        $(By.className("button__text")).click();
//        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(14));
//    }
//
//    @Test
//    void shouldSelectCityFromList() {
//        Configuration.headless = true;
//        String date = LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        String city = "Мо";
//
//        open("http://localhost:9999/");
//
//        $("[data-test-id=city] input").setValue(city);
//        $$("[class=menu-item__control]").findBy(Condition.ownText(city)).click();
//        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
//        $("[data-test-id=date] input").setValue(date);
//        $("[data-test-id=name] input").setValue("Печкин-Лавочкин Иван");
//        $("[data-test-id=phone] input").setValue("+79998887766");
//        $("[data-test-id=agreement]").click();
//        $(By.className("button__text")).click();
//        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(14));
//    }
//
//    @Test
//    void shouldSelectDateFromCalendar() {
//        Configuration.headless = true;
//        String day = LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd"));
//
//        open("http://localhost:9999/");
//
//        $("[data-test-id=city] input").setValue("Москва");
//        $("[class=input__icon]").click();
//        $$("[role=gridcell]").findBy(text(day)).click();
//        $("[data-test-id=name] input").setValue("Печкин-Лавочкин Иван");
//        $("[data-test-id=phone] input").setValue("+79998887766");
//        $("[data-test-id=agreement]").click();
//        $(By.className("button__text")).click();
//        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(14));
//    }
//}

