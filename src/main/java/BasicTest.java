//Importowanie bibliotek do klasy
import org.testng.Assert;
import org.testng.annotations.Test;

//Definicja klasy
public class BasicTest {

    /* Utworzenie prywatnego pola klasy - będzie ono dostępne tylko w danej klasie, klasy dziedziczące po niej nie będą miały dostępu do tego pola - pole klasy jest dostępne w obrębie całej klasy, czyli
    np. we wszystkich metodach w niej utworzonych
     */

    private Boolean isTrue;

    //Oznaczenie metody jako test, adnotacja @Test jest skłądnikiem TestNG
    @Test
    //Deklaracja publicznej metody - wszystkie inne klasy będą miały do niej dostęp, metoda ma typ "void", tzn że nie zwraca ona żadnej wartości - nie możemy wewnątrz niej użyć instrukcji "return"
    public void test() {
        /* Deklaracja zmiennej tekstowej wraz z przypisaniej do niej wartości (inicjalizacja zmiennej) - zmienna różni się od pola klasy tym, że jest ona dostępna
        tylko wewnątrz danej metody, nie jest ona dostępna na zewnątrz tej metody
         */
        String text = "My first variable";

        //Wypisanie tekstu
        System.out.println("Test");

        //Wypisanie wartości zmiennej
        System.out.println(text);
        //isTrue = checkIfTrue(true);

        //Wypisanie wartości zmiennej
        System.out.println(isTrue);

        /*Użycie asercji, która sprawdza, czy wyrażenie jest prawdziwe (pierwszy argument) - jeżeli nie, to wypisany zostanie tekst podany w drugim argumencie - wewnątrz asercji następuje uruchomienie metody
        "checkIfTrue" z przekazaniem do niej argumentu "true"
         */
        Assert.assertTrue(checkIfTrue(true), "Got wrong value, expected: true, got: " + isTrue);
    }

    // Oznaczenie metody testowej jako zależnej od wykonania innej metody - jeżeli wykonanie metody nadrzędnej zakończy się niepowodzeniem, to wykonanie tej metody zostanie pominięte
    @Test(dependsOnMethods = "test")
    public void test2() {
        Assert.assertTrue(checkIfTrue(true), "Got wrong value, expected: true, got: " + isTrue);
    }


    /* Deklaracja pryweatnej metody typu Boolean - oznacza to, że będzie ona zwracała wartość typu logicznego true/false - jeżeli metodzie podajemy typ inny niż "void",
    to musimy wewnątrz niej zwracać przy użyciu instrukcji "return" jakąś wartość o określonym typie - w naszym przypadku typu "Boolean" - jeżeli dla metody typu Boolean chcielibyśmy zwrócić
    wartość innego typu, np. "String"(tekst) lub "Int"(liczba całkowita), to Java krzyknęłaby wyjątkiem, który widzielibyśmy już na poziomie IDE

    Metoda na wejściu przyjmuje parametr typu logicznego "Boolean", który przy wywołaniu metody musi zostać przekazany do niej w postaci argumentu.
     */
    private Boolean checkIfTrue(Boolean x) {
        //Deklaracja loklanej zmiennej typu Boolean
        Boolean returnedValue;
        //Inicjacjlizcja warunku
        if (x == false) {
            //Operacja wykonywana jeżeli x ma wartość false
            returnedValue = false;
        } else {
            //Operacja wykonywana, jeżeli warunek wewnątrz instrukcji "if" nie został spełniony
            returnedValue = true;
        }
        //zwrócenie wartości przez metodę
        return returnedValue;
    }
}
