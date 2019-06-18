package selenium.chessboard;

import org.testng.Assert;
import org.testng.annotations.Test;
import commons.TestBase;

public class ChessboardTableNonExistenceTest extends TestBase {

    @Test
    public void verifyChessboardTableNonExistence(){
        /* Sprawdzenie, czy szachownica nie jest widoczna po wczytaniu strony - jeżeli nie jest, to w metodzie isElementPresentById leci wyjątek
        i zwracana jest wartość false, którą podstawiamy do asercji assertFalse, która zakończy się niepowodzeniem, jeżeli szachownica będzie widoczna
        od razu po wczytaniu strony
         */
        Assert.assertFalse(isElementPresentById("chessboardTable"), "Chessboard table visible, should not.");
    }
}
