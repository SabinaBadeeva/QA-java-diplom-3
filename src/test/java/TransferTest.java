import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.assertj.core.api.SoftAssertions;



public class TransferTest extends Resources {

    public String currentUrl = null;
    private SoftAssertions softAssertions;

    @Test
    @Description("После успешного входа на странице видна кнопка Оформить заказ")
    @Step("Вход через кнопку в форме восстановления пароля")
    public void loginWithForgotPassword() {
        //Клик по Войти в аккаунт
        mainPage.clickPersonalAccountButton();
        // Клик по Восстановить пароль
        authorisationPage.clickRecoverPassword();
        //Клик на Войти
        authorisationPage.clickRememberPassword();
        //Войти в аккаунт
        authorisationPage.getEnterAccount(EMAILAUTH, PASSWORDAUTH);
        //Проверить - видна кнопка Оформить заказ
        assertEquals("Оформить заказ", transfer.createOrderButtonGetText());
    }


    @Test
    @Description("Проверить, что из Личного кабинета через логотип, можно перейти на главную страницу ")
    @Step("Переход  по клику на логотип Stellar Burgers")
    public void getPageLogo()  {
        // Войти в аккаунт
        mainPage.clickPersonalAccountButton();
        authorisationPage.getEnterAccount(EMAILAUTH, PASSWORDAUTH);
        //Войти в Личный кабинет
        mainPage.clickPersonalAccountButton();
        // проверяем, если ЛОГОТИП видиден, то можно по нему кликнуть
        transfer.headerLogoIsClick();
        //перешли на Главную страницу и получаем её url
        currentUrl = driver.getCurrentUrl();
        //проверяем, что  ЛОГОТИП ведет на Главную страницу
        String mainUrlPage = currentUrl;
        String logoMain = URL;
        assertEquals(logoMain, mainUrlPage);
    }

    @Test
    @Description("Проверить: 1) при переходе по кнопке Личный кабинет, попадаем на страницу авторизации," +
            "2) после авторизации с Главной страницы, нажав на Личный кабинет, попадаем в свой личный кабинет ")
    @Step("Переход по кнопке Личный кабинет")
    public void getTransferButtonPrivateAccountTest() throws InterruptedException {
        //Нажать на  Личный кабинет
        mainPage.clickPersonalAccountButton();
        // При успешном переходе попадаем на страницу авторизации, где видна кнопка Войти
        authorisationPage.statusOfRegistrationIsDisplayed();
        //Войти в аккаунт
        authorisationPage.getEnterAccount(EMAILAUTH, PASSWORDAUTH);
        // Нажать на Личный кабинет
        mainPage.clickPersonalAccountButton();
        //Получить значение поля Name
        String actualName = privateAccount.getNameValue();
        // Получить значение поля Email
        String actualEmail = privateAccount.getEmailValue();
        Resources.specification();
        //Проверить, если значение полей совпадают,- находимся в своем Личном кабинете
        assertEquals(NAMEAUTH, actualName);
        assertEquals(EMAILAUTH, actualEmail);
    }

    @Test
    @Description("Проверить, что из Личного кабинета по кнопке Конструктор переходим на главную страницу с оформлением заказа")
    @Step("Переход из личного кабинета по кнопке Конструктор")
    public void getConstructorButtonTest() {
        //Нажать на  Личный кабинет
        mainPage.clickPersonalAccountButton();
        //Войти в аккаунт
        authorisationPage.getEnterAccount(EMAILAUTH, PASSWORDAUTH);
        // Войти в Личный кабинет
        mainPage.clickPersonalAccountButton();
        //Нажать на кнопку Конструктор
        transfer.headerConstructorIsClick();
        //Проверить - видна кнопка Оформить заказ
        assertEquals("Оформить заказ", transfer.createOrderButtonGetText());
    }

    @Test
    @Description("Проверить, что при выходе из Личного кабинета видна кнопка Войти")
    @Step("Выход из аккаунта")
    public void getLogOutButtonTest() throws InterruptedException {
        //Находимся на странице авторизации
        driver.get(CURRENTURLLOGO);
        //Войти в аккаунт
        authorisationPage.getEnterAccount(EMAILAUTH, PASSWORDAUTH);
        // Войти в Личный кабинет
        mainPage.clickPersonalAccountButton();
        Resources.specification();
        //Нажать Выход
        privateAccount.clickLogOutButton();
        Resources.specification();
        //Проверить, вышли на страницу Авторизации
        assertEquals(CURRENTURLLOGO, driver.getCurrentUrl());
    }

    @Test
    @Description("Проверить -что отображается блок Булки")
    @Step("Проверить,что после нажатия на span Булки, отображается блок Булки с различным содержанием current")
    public void getClickBuns() {
        //Клик по разделу Булки
        transfer.clickBunList();
        assertTrue("Element is invisible", transfer.getBunsListValue().contains("current"));
    }

    @Test
    @Description("Проверить -что работает скролл и отображается блок Соусы")
    @Step("Проверить,что после нажатия на span Соусы, отображается блок Соусы с различным содержанием current")
    public void getClickSauces() {
        //Клик по разделу Соусы
        transfer.clickSaucesList();
        // scroll
        transfer.scrollSauceBlock();
        assertTrue("Element is invisible", transfer.getSaucesListValue().contains("current"));
    }

    @Test
    @Description("Проверить, что работает скролл и отображается блок Начинки")
    @Step("Проверить,что после нажатия на span Начинки, отображается блок Начинки с различным содержанием current")
    public void getClickFillings() {
        // клик по разделу Начинки
        transfer.clickFillingsList();
        // scroll
        transfer.scrollFillingsBlock();
        //Проверить,что отображается блок Начинки
        assertTrue("Element is invisible", transfer.getFillingsLstValue().contains("current"));
    }
}
