package selenium.o2;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import commons.TestBase;

public class O2LoginTest extends TestBase {

    protected WebElement emailField;
    protected WebElement passwordField;
    protected WebElement loginButton;
    protected WebElement errorMessage;

    private static final String emailFieldId = "login";
    private static final String passwordFieldId = "password";
    private static final String loginButtonId = "login-button";
    private static final String errorMessageId = "login-error-message";

    private static final String login = "test@o2.pl";
    private static final String password = "test123";

    private static final String errorMessageExpectedText = "Podany login i/lub hasło są nieprawidłowe.\nSpróbuj jeszcze raz.";

    @Test
    public void o2LoginTest() throws InterruptedException {
        driver.get("https://poczta.o2.pl/zaloguj");

        emailField = getElementById(emailFieldId);
        emailField.click();
        emailField.sendKeys(login);

        passwordField = getElementById(passwordFieldId);
        passwordField.click();
        passwordField.sendKeys(password);

        loginButton = getElementById(loginButtonId);
        loginButton.click();

        errorMessage = getElementById(errorMessageId);
        String errorMessageText = errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertEquals(errorMessageText, errorMessageExpectedText);
    }

}
