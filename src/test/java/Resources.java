import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.RegistrationPage;
import org.example.pageObject.AuthorisationPage;
import org.example.pageObject.MainPage;
import org.example.pageObject.PrivateAccount;
import org.example.pageObject.TransferButton;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Resources {
    public  ChromeDriver driver;
    public MainPage mainPage;
    public PrivateAccount privateAccount;
    public RegistrationPage registrationPage;
    public TransferButton transfer;
    public AuthorisationPage authorisationPage;

    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    public static final String  CURRENTURLLOGO = "https://stellarburgers.nomoreparties.site/login";
    public static final String CURRENTACCAUNT = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String NAME = RandomStringUtils.randomAlphabetic(6);
    public static final String EMAIL = RandomStringUtils.randomAlphabetic(5) + "@yandex.ru";
    public static final String PASSWORD = "yandex01234";
    public static final String PASSWORD_2 = "ya123";
    public static final String NAMEAUTH = "stellar";
    public static final String EMAILAUTH = "stell_yand@yandex.ru";
    public static final String PASSWORDAUTH = "yandex12345";


    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\tools\\yandex\\Yandex.exe");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        mainPage = new MainPage(driver);
        privateAccount = new PrivateAccount(driver);
        authorisationPage = new AuthorisationPage(driver);
        registrationPage = new RegistrationPage(driver);
        transfer= new TransferButton(driver);}

    public static void specification() throws InterruptedException{
        Thread.sleep(2000);
    }
    @After
    @Step("Quit_browser")
    public void logOut(){
        driver.quit();
    }
}
