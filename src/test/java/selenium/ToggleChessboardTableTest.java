package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ToggleChessboardTableTest extends TestBase{

    @Test
    public void verifyChessboardTableToggle() throws InterruptedException {
        /*Pobranie przycisku ze strony - musimy to robić na samym początku, ponieważ po każdym wcześniejszym teście niszczymy obiekt driver (metoda quit())
        i w tym momencie przycisk nie jest dostępny
         */
        chessboardButton = getElementById("chessboardButton");

        //Sprawdź pokazywanie szachownicy
        showChessboardTable();

        //Sprawdź ukrywanie szachownicy
        hideChessboardTable();

        //Sprawdź pokazywanie szachownicy
        showChessboardTable();

        //Sprawdź ukrywanie szachownicy
        hideChessboardTable();
    }

    //Deklaracja metody mającej na celu weryfikację poprawności pokazywania szachownicy
    private void showChessboardTable() {

        //Oczekiwany tekst na przycisku po wyświetleniu szachownicy
        String expectedText = "Ukryj szachownicę";

        //Kliknięcie przycisku
        chessboardButton.click();

        //Sprawdzenie, czy szachownica jest wyświetlona
        Assert.assertTrue(isElementPresentById("chessboardTable"), "Chessboard not visible!");

        /*Ponowne pobranie przycisku ze strony - WebDriver nie aktualizuje stanu przycisku, tylko trzyma jego stan od momentu jego utworzenia,
        żeby mieć jego stan po zmianie, musimy ponownie pobrać go ze strony
         */
        chessboardButton = getElementById("chessboardButton");

        //Pobranie tekstu z przycisku
        String buttonText = chessboardButton.getText();

        //Weryfikacja tekstu na przycisku
        Assert.assertEquals(buttonText, expectedText);
    }

    //Deklaracja metody mającej na celu weryfikację poprawności ukrywania szachownicy
    private void hideChessboardTable() throws InterruptedException {

        //Oczekiwany tekst na przycisku po ukryciu szachownicy
        String expectedText = "Pokaż szachownicę";

        //Kliknięcie przycisku
        chessboardButton.click();

        /*Zatrzymanie wątku na jedną sekundę - animacja ukrywania szachownicy nie dzieje się od razu - bez tego dostalibyśmy informację, że
        szachownica jest cały czas widoczna na stronie
         */
        Thread.sleep(1000);

        //Sprawdzenie, czy szachownica nie jest wyświetlona
        Assert.assertFalse(isElementPresentById("chessboardTable"), "Chessboard visible!");

        //Ponowne pobranie przycisku - z tego samego powodu, co w metodzie powyżej
        chessboardButton = getElementById("chessboardButton");

        //Pobranie tekstu z przycisku
        String buttonText = chessboardButton.getText();

        //Weryfikacja tekstu na przycisku
        Assert.assertEquals(buttonText, expectedText);
    }


}
