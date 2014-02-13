import java.util.Vector;

/**
 * Created by bigboss on 12/02/2014.
 */
public class TennisScore {

    Vector<Integer> score;
    public final int GAME_WIN_MARGIN = 2;
    public final int MIN_NO_GAMES_TO_WIN_SET = 6;

    public TennisScore(int player1SetScore, int player2SetScore, int player1GameScore, int player2GameScore) {
        score = new Vector<Integer>(4);
        score.add(0,new Integer(player1SetScore));
        score.add(1,new Integer(player2SetScore));
        score.add(2,new Integer(player1GameScore));
        score.add(3,new Integer(player2GameScore));
    }

    public TennisScore() {
        score = new Vector<Integer>(4);
        score.add(0,new Integer(0));
        score.add(1,new Integer(0));
        score.add(2,new Integer(0));
        score.add(3,new Integer(0));
    }

    // Increments the score in a tennis game based on which player won the point, i.e. player would be 1, or 2
    public String incrementScore(int player) {
        int playerSetScore;
        int playerGameScore;
        int opponentSetScore;
        int opponentGameScore;

        if (player == 1) {
            playerSetScore = score.elementAt(0);
            opponentSetScore = score.elementAt(1);
            playerGameScore = score.elementAt(2);
            opponentGameScore = score.elementAt(3);
        }
        else {
            playerSetScore = score.elementAt(1);
            opponentSetScore = score.elementAt(0);
            playerGameScore = score.elementAt(3);
            opponentGameScore = score.elementAt(2);
        }

        playerGameScore++;
        // Game score reset if game is won
        if (playerGameScore == 4) {
            if (opponentGameScore < 3) {
                playerGameScore = 0;
                opponentGameScore = 0;
                playerSetScore++;
            }

            else if (opponentGameScore == 4) {
                opponentGameScore = 3;
                playerGameScore = 3;
            }
        }

        if (playerGameScore == 5) {
            playerSetScore++;
            playerGameScore = 0;
            opponentGameScore = 0;
        }

        if (player == 1) {
            score.setElementAt(new Integer(playerSetScore), 0);
            score.setElementAt(new Integer(opponentSetScore), 1);
            score.setElementAt(new Integer(playerGameScore), 2);
            score.setElementAt(new Integer(opponentGameScore), 3);
        }
        else {
            score.setElementAt(new Integer(playerSetScore), 1);
            score.setElementAt(new Integer(opponentSetScore), 0);
            score.setElementAt(new Integer(playerGameScore), 3);
            score.setElementAt(new Integer(opponentGameScore), 2);
        }

        return printScore();
    }

    // Returns a string representation of the tennis score
    public String printScore() {
        Integer player1SetScore = score.elementAt(0);
        Integer player2SetScore = score.elementAt(1);
        Integer player1GameScore = score.elementAt(2);
        Integer player2GameScore = score.elementAt(3);

        StringBuffer sb = new StringBuffer();
        sb.append(player1SetScore.toString());
        sb.append("-");
        sb.append(player2SetScore.toString());
        sb.append(" ");
        sb.append(gameScoreToString(player1GameScore));
        sb.append("-");
        sb.append(gameScoreToString(player2GameScore));

        // If a game has been won print a victory message
        int gameDifference = Math.abs(player1SetScore - player2SetScore);
        if ((gameDifference >= GAME_WIN_MARGIN)
                && (player1SetScore >= MIN_NO_GAMES_TO_WIN_SET || player2SetScore >= MIN_NO_GAMES_TO_WIN_SET))
        {
            sb.append(System.getProperty("line.separator"));
            String winner = (player1SetScore > player2SetScore) ? "Player 1" : "Player 2";
            sb.append("Match has been won by " + winner);
        }

        return sb.toString();
    }

    // Returns the game score as a String
    public String gameScoreToString(Integer gameScore) {
        int score = gameScore.intValue();
        String scoreString = "";

        switch(score) {
            case 0:
                scoreString = "0";
                break;
            case 1:
                scoreString = "15";
                break;
            case 2:
                scoreString = "30";
                break;
            case 3:
                scoreString = "40";
                break;
            case 4:
                scoreString = "Adv";
                break;
            default:
                break;

        }

        return scoreString;
    }

}
