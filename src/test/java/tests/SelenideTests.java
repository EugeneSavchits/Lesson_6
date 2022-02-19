/*
package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

//@Listeners({SoftAsserts.class})//если хотим чтобы все проверки прошли и тест не останавливался после первой неудачной проверки. Связан с Configuration.assertionMode = SOFT
public class SelenideTests {

    String url = "https://qa1505.testrail.io";
    String username = "atrostyanko+0401@gmail.com";
    String password = "QqtRK9elseEfAk6ilYcJ";

    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

    @Test
    public void userCanLogin() {
        //Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        //Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT; //если хотим чтобы все проверки прошли и отобразились и тест не останавливался после первой неудачной проверки
        //Configuration.headless = false;

        //Начинаем писать тест
        open("/");

       $(By.id("name")).setValue(username);
       $("#password").val(password); //аналог
       $("#button_primary").click();

       $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

       open("/index.php?/admin/projects/overview");
       $$(By.className("hoverSensitive"))
               .shouldHaveSize(388) //проверка числа проектов найденных в результате поиска
               .find(text("123456")) //нахождение элемента в найденом списке проектов
               .find(By.tagName("a")) //нахождение подэлемента относительно элемента text("123456")
               .click();

       $("#announcment")
               .should(exist) //проверка что элемент существует
               .shouldBe(visible) //проверка что элемент видимый
               .shouldHave(exactText("This is the description for the project")); //проверка что элемент должен иметь конкретный текст

    }

    @Test
    public void test1() {
        //Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        //Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT; //если хотим чтобы все проверки прошли и отобразились и тест не останавливался после первой неудачной проверки
        //Configuration.headless = false;

        //Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password); //аналог
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

       $$(".chart-legend-name") //нахождение четырех видимых проектов на странице dashboard справа
               .filter(visible) //фильтрация по видимым элементам в найденном массиве элементов
               .shouldHave(
                       texts(
                               "123456",
                               "aaaDencheck",
                               "aaaDencheck",
                               "aaaDencheck" //прописываем все элементы по тексту которые хотим проверить
                       )
               );
    }

    @Test
    public void test2() throws FileNotFoundException {
        //Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        //Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT; //если хотим чтобы все проверки прошли и отобразились и тест не останавливался после первой неудачной проверки
        //Configuration.headless = false;

        //Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password); //аналог
        $("#button_primary").click();

        //нахождения элемента проекта по полному тексту и проверка на видимость
        $(byText("asdasd")).shouldBe(visible);

        //нахождения элемента проекта по части текста и проверка на видимость
        $(withText("asd")).shouldBe(visible);

        //Selenide Элемент
        //Получение родительского элемента
        SelenideElement parent = $(byText("asdasd")).parent();

        //Стандартные команды
        $(byText("asdasd")).innerText();
        $(byText("asdasd")).innerHtml();
        $(byText("asdasd")).sendKeys();
        $(byText("asdasd")).click();
        $(byText("asdasd")).scrollTo();
        $(byText("asdasd")).closest("tr"); //находит ближайший элемент с каким-то тэгом, ищет только по tagname
        $(byText("asdasd")).find(By.xpath("")); //поиск исключительно внутри элемента как в обертке
        $(byText("asdasd")).doubleClick();
        $(byText("asdasd")).contextClick();
        $(byText("asdasd")).dragAndDropTo("");
        $(byText("asdasd")).hover(); //когда налезаем на элемент

        //Если элемент является input и в него можно загрузить файл с указанием абсалютного пути к файлу
        $(byText("asdasd")).uploadFile(new File(""));

        $(byText("asdasd")).download(); //скачивание файла

        sleep(5000);//стандартный метод sleep


    }

    @Test
    public void userCanLoginWithLoginPage() {

        // Начинаем писать тест
        open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(username);

       loginPage.getPasswordField().val(password);
       loginPage.getLoginButton().click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHaveSize(388)
                .find(text("123456"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));
    }
}
*/
