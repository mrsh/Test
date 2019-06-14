package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChessboardButtonExistenceTest extends TestBase{

    @Test

    //Sprawdzenie, czy przycisk do obsługi szachownicy jest widoczny po wczytaniu strony
    public void verifyChessboardButtonExistence() {

        //Wyszukanie elementu przy pomocy xpath
        //driver.findElement(By.xpath("//*[@id=\"chessboardButton\"]"));

        //Wyszukanie elementu na podstawie jego atrybutu id
        //driver.findElement(By.id("1chessboardButton"));

        /*Wyszukanie elementu na podstawie jego atrybutu id z tą rónicą, że tutaj wykorzystujemy pole wait utworzone w klasie TestBase, w której
        zdefiniowaliśmy ile czasu Selenium ma czekać na element
         */
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1chessboardButton")));

        /*powyższa instrukcja została opakowana w metodę getElementById, dzięki czemu łatwiej jest nam jej użyć, przycisk pobrany ze strony
        przypisujemy do pola chessboardButton typu WebElement, które jest zadeklarowane w klasie TestBase*/
        chessboardButton = getElementById("chessboardButton");
    }

    /*Sprawdzenie tekstu na przycisku, które jest wykonywane tylko wtedy, kiedy test verifyChessboardButtonExistence() zakończył się sukcesem - jeżeli nie,
    to zostanie on pominięty (Skipped)
     */
    @Test(dependsOnMethods = "verifyChessboardButtonExistence")
    public void verifyChessboardButtonText() {

        //Deklaracja oczekiwanego tekstu przycisku po wczytaniu strony
        String expectedText = "Utwórz szachownicę";

        //Pobranie tekstu na przycisku
        String buttonText = chessboardButton.getText();

        //Weryfikacja tekstu przy pomocy asercji assertTrue
        //Assert.assertTrue(buttonText.equals(expectedText), "Wrong button text, expected: " + expectedText + ", got: " + buttonText + ".");

        /*Weryfikacja tekstu przy pomocy asercji assertEquals - w tym przypadku jest to lepsze rozwiązanie - tej asercji powinniśmy używać, jeżeli
        chcemy porównać, czy dwa obiekty są takie same
         */
        Assert.assertEquals(buttonText, expectedText);
    }
}
