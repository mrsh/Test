package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    /*Deklaracja pola driver - póki co jest ono puste, dzięki temu, że klasy z testami dziedziczą po klasie TestBase,
    mają one dostęp do tego obiektu, chyba że nadalibyśmy mu modyfikator dostępu private - wtedy byłby on dostępny tylko w tej klasie, modyfikator protected mówi,
    że obiekt będzie dostępny w danej klasie i klasach po niej dziedziczących, public że jest on dostępny dla wszystkich klas
     */
    protected WebDriver driver;

    /*Deklaracja pola typu WebDriverWait, które pozwoli na przypisanie mu konkretnego czasu oczekiwania, dzięki tworzeniu takich "waitów" jesteśmy w stanie wskazać,
    że np. na dany element mamy czekać 3, a na inny 5 sekund.
     */
    protected WebDriverWait wait;

    /*Deklaracja pola typu ChromeOptions, które jest nam potrzebne, jeżeli chcemy np. uruchomić testy w trybie headless - wtedy cały interfejs strony
    zostanie wyrenderowany w pamięci operacyjnej
     */
    private ChromeOptions options;

    /*Deklaracja pola typu WebElement - tego typu używamy do przypisywania polom/zmiennym obiektów pobranych na stronie, szczególnie kiedy
    mamy zamiar na nim wykonywać kilka operacji, np. sprawdzić jego tekst, style, a później go kliknąć
     */
    protected WebElement chessboardButton;


    /* Deklaracja metody, która zostanie uruchomiona przed uruchomieniem pierwszego testu - metoda oznaczona tą adnotacją zostanie wywołana tylko raz*/
    @BeforeSuite
    private void setChromedriverPath() {
        /*Ustawienie ścieżki do chromedriver.exe, który jest pośrednikiem między naszym kodem a przeglądarką,
        chromedriver sam ogarnia sobie, gdzie jest nasza przeglądarka*/
        System.setProperty("webdriver.chrome.driver", "C:\\szkolenie-QA-repo\\Test\\chromedriver.exe");
    }


    /*Deklaracja metody, która zostanie wykonana przed każdym testem*/
    @BeforeTest
    private void getChessboardPage(){

        //Inicjacja obiektu ChromeOptions options - w pewnym momencie mieliśmy to w @BeforeSuite, ale w @AfterTest ubijamy całego drivera, także przed każdym testem musimy go tworzyć od nowa
        options = new ChromeOptions();

        //Uruchamianie testów w trybie headless - interfejs graficzny jest renderowany w pamięci operacyjnej - nie widzimy na ekranie jak testy się wykonują
        //options.addArguments("headless");

        //Inicjacja przeglądarki z przekazaniem do niej opcji, które dla niej ustawiliśmy
        driver = new ChromeDriver(options);

        //Ustawienie globalnego timeoutu dla całęgo drivera
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Inicjacja waita utworzonego przez naz
        wait = new WebDriverWait(driver, 5);

        //Maksymalizacja okna przeglądarki
        driver.manage().window().maximize();

        //Wejście na wskazaną stronę
        driver.get("C:/szkolenie-QA-repo/html/chessboard/index.html");
    }

    //Deklaracja metody, która zostanie uruchomiona po każdym teście
    @AfterTest
    private void guit() {
        //Zamknięcie przeglądarki i zniszczenie obiektu driver
        driver.quit();
    }

    //Deklaracja metody, kóra na wejściu przyjmuje parametr id typu tekstowego i zwraca wartość typu WebElement
    protected WebElement getElementById(String id) {
        //Zwrócenie elementu o wskazanym id - metoda będzie czekać na element czas określony w polu "wait", jeżeli do tego czasu go nieznajdzie, to zwróci wyjątek
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    //Deklaracja metody zwracającej typ logiczny, która na wejściu przyjmuje parametr id typu tekstowego. Oznaczamy metodę , że może ona zwrócić wyjątek TimeoutException
    protected boolean isElementPresentById(String id) throws TimeoutException {
        //Spróbuj coś zrobić
        try {
            //Pobierz element o wskazanym identyfikatorze
            getElementById(id);

            //Zwróc wartość true
            return true;
        }
        //Zrób coś, jeżeli wewnątrz bloku try poleci wyjątek TimeoutException
        catch (TimeoutException e) {
            //Zwróc wartość false
            return false;
        }
    }
}
