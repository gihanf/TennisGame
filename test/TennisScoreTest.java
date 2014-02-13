import junit.framework.TestCase;
import sun.jvm.hotspot.oops.ExceptionTableElement;

/**
 * Created by bigboss on 12/02/2014.
 */
public class TennisScoreTest extends TestCase {

    TennisScore ts;

    public void setUp() throws Exception {
        ts = new TennisScore();
        super.setUp();
    }

    public void testPlayer1WinningFirstGame() throws Exception {
        assertEquals("0-0 15-0",ts.incrementScore(1));
        assertEquals("0-0 30-0",ts.incrementScore(1));
        assertEquals("0-0 40-0",ts.incrementScore(1));
        assertEquals("1-0 0-0",ts.incrementScore(1));
        assertEquals("1-0 15-0",ts.incrementScore(1));
    }

    public void testPlayer2WinningFirstGame() throws Exception {
        assertEquals("0-0 0-15",ts.incrementScore(2));
        assertEquals("0-0 0-30",ts.incrementScore(2));
        assertEquals("0-0 0-40",ts.incrementScore(2));
        assertEquals("0-1 0-0",ts.incrementScore(2));
        assertEquals("0-1 0-15",ts.incrementScore(2));
    }

    public void testGameGoingToDeuce() throws Exception {
        ts = new TennisScore(1,3,0,0);
        assertEquals("1-3 15-0", ts.incrementScore(1));
        assertEquals("1-3 15-15", ts.incrementScore(2));
        assertEquals("1-3 30-15", ts.incrementScore(1));
        assertEquals("1-3 30-30", ts.incrementScore(2));
        assertEquals("1-3 40-30", ts.incrementScore(1));
        assertEquals("1-3 40-40", ts.incrementScore(2));
    }

    public void testDeuceGameBeingWon() throws Exception {
        ts = new TennisScore(1,3,3,3);
        assertEquals("1-3 40-Adv", ts.incrementScore(2));
        assertEquals("1-3 40-40", ts.incrementScore(1));
        assertEquals("1-3 Adv-40", ts.incrementScore(1));
        assertEquals("2-3 0-0", ts.incrementScore(1));
    }

    public void testMatchWonByPlayer1() throws Exception {
        ts = new TennisScore(6,5,3,0);
        assertEquals("7-5 0-0\nMatch has been won by Player 1", ts.incrementScore(1));
    }

    public void testMatchWonByPlayer2() throws Exception {
        ts = new TennisScore(8,9,3,3);
        assertEquals("8-9 40-Adv", ts.incrementScore(2));
        assertEquals("8-10 0-0\nMatch has been won by Player 2", ts.incrementScore(2));
    }

    public void testMatchWonByPlayerLargeMargin() throws Exception {
        ts = new TennisScore(5,2,3,0);
        assertEquals("6-2 0-0\nMatch has been won by Player 1", ts.incrementScore(1));
    }

    public void testIncrementPlayer2Score() throws Exception {

        assertEquals("0-0 0-15", ts.incrementScore(2));
    }
}
