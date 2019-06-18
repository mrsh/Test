package selenium.chessboard;

import org.testng.Assert;

import org.testng.annotations.Test;
import commons.TestBase;

public class PageTitleTest extends TestBase {


        //Deklaracja testu sprawdzającego tytuł strony
        @Test
        public void pageTitleTest() {

            //Uśpienie wątku na 2 sekundy
            //Thread.sleep(2000);

            //Pobranie tytułu strony
            String pageTitle = driver.getTitle();

            //Deklaracja oczekiwanego tytułu strony
            String expectedTitle = "Chessboard";

            //Weryfikacja tytułu strony
            Assert.assertEquals(pageTitle, expectedTitle);
        }
}
