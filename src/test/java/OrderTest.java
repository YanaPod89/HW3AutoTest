import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class OrderTest {

    @Test
    void shouldTest() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Яна Подольская");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("+79137893070");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldTestNameEnglishLetters() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Iana");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("+79137893070");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=name] .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

    }

    @Test
    void shouldTestNameNumber() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Яна Подольская15");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("+79137893070");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=name] .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

    }

    @Test
    void shouldTestNameSymbols() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Яна Подольская%");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("+79137893070");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=name] .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

    }

    @Test
    void shouldNameTestPhoneSymbols() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Яна Подольская");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("++79137893070");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    void shouldNameTestPhoneMoreNumbers() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Яна Подольская");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("+791378930700");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    void shouldNameTestPhoneLessNumbers() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Яна Подольская");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("+7913789307");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    void shouldNameTestPhoneSpace() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Яна Подольская");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("+7913 893070");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    void shouldNameTestNumberInsteadPlus() {
        open("http://localhost:9999");

        SelenideElement form = $("[data-test-id=name]");
        form.$("[data-test-id=name] input").setValue("Яна Подольская");

        SelenideElement form2 = $("[data-test-id=phone]");
        form2.$("[data-test-id=phone] input").setValue("+79137893070");

        $("[data-test-id=agreement]").click();

        $(".button__content").click();

        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }
}

