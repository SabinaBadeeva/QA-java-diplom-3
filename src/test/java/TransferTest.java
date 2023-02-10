import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransferTest extends Resources {
    public String currentUrl = null;


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
        transfer.createOrderButtonGetText("Оформить заказ");}


    @Test
    @Description("Проверить, что из Личного кабинета через логотип, можно перейти на главную страницу ")
    @Step("Переход  по клику на логотип Stellar Burgers")
    public void getPageLogo() {
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
        System.out.println(mainUrlPage.equals(logoMain) + " Мы находимся на главной странице");}

    @Test
    @Description("Проверить: 1) при переходе по кнопке Личный кабинет, попадаем на страницу авторизации," +
            "2) после авторизации с Главной страницы, нажав на Личный кабинет, попадаем в свой личный кабинет ")
    @Step("Переход по кнопке Личный кабинет")
    public void getTransferButtonPrivateAccountTest() throws InterruptedException {
        //Нажать на  Личный кабинет
        mainPage.clickPersonalAccountButton();
        // При успешном переходе попадаем на страницу авторизации, где видна кнопка Войти
        authorisationPage.statusOfRegistration("Войти");
        //Войти в аккаунт
        authorisationPage.getEnterAccount(EMAILAUTH, PASSWORDAUTH);
        // Нажать на Личный кабинет
        mainPage.clickPersonalAccountButton();
        //Получить значение поля Name
        String actualName = privateAccount.getNameValue();
        // Получить значение поля Email
        String actualEmail = privateAccount.getEmailValue();
        Resources.specification();
        //Проверить, значение полей совпадают, поэтому  находимся в своем Личном кабинете
        assertEquals(NAMEAUTH, actualName);
        assertEquals(EMAILAUTH, actualEmail);
        // Проверить, что находимся на стрнице Личного кабинета
        assertEquals("https://stellarburgers.nomoreparties.site/account/profile", driver.getCurrentUrl());}

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
        transfer.createOrderButtonGetText("Оформить заказ");}

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
        assertEquals(CURRENTURLLOGO, driver.getCurrentUrl());}

    @Test
    @Description("Проверить,что отображается блок Булки")
    @Step("Проверить, что работает переход к разделу Булки")
    public void getClickBuns() {
        //Клик по разделу Булки
        transfer.clickBunList();
        //Проверить,что отображается блок Булки
        assertTrue("Element is invisible", transfer.isHeaderBunsVisible());}

    @Test
    @Description("Проверить,что работает скролл и отображается блок Соусы")
    @Step("Проверить, что работает переход к разделу Соусы")
    public void getClickSauces() {
        //Клик по разделу Соусы
        transfer.clickSaucesList();
        // scroll
        transfer.scrollSauceBlock();
        //Проверить,что отображается блок Соусы
        assertTrue("Element is invisible", transfer.isHeaderSaucesVisible());
    }

    @Test
    @Description("Проверить,что что работает скролл и отображается блок Начинки")
    @Step("Проверить, что работает переход к разделу Начинки")
    public void getClickFillings() {
        // клик по разделу Начинки
        transfer.clickFillingsList();
        // scroll
        transfer.scrollFillingsBlock();
        //Проверить,что отображается блок Начинки
        assertTrue("Element is invisible", transfer.isHeaderFillingsVisible());
    }
}
