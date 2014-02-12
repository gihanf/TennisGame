import junit.framework.TestCase;

/**
 * Created by bigboss on 12/02/2014.
 */
public class TennisScoreTest extends TestCase {

    TennisScore ts;

    public void setUp() throws Exception {
        ts = new TennisScore();
        super.setUp();
    }


    public void testIncrementScore() throws Exception {
        assertEquals("0-0 15-0",ts.incrementScore(1));
        assertEquals("0-0 30-0",ts.incrementScore(1));
    }

    public void testIncrementPlayer2Score() throws Exception {

        assertEquals("0-0 0-15", ts.incrementScore(2));
    }
}
