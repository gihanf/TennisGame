import java.util.Vector;

/**
 * Created by bigboss on 12/02/2014.
 */
public class TennisScore {

    public int player1SetScore;
    public int player2SetScore;
    public int player1GameScore;
    public int player2GameScore;

    Vector<Integer> score;

    public TennisScore(int player1SetScore, int player2SetScore, int player1GameScore, int player2GameScore) {
        this.player1SetScore = player1SetScore;
        this.player2SetScore = player2SetScore;
        this.player1GameScore = player1GameScore;
        this.player2GameScore = player2GameScore;
    }

    public TennisScore() {
        score = new Vector<Integer>(4);
        score.add(0,new Integer(0));
        score.add(1,new Integer(0));
        score.add(2,new Integer(0));
        score.add(3,new Integer(0));
    }

    public String incrementScore(int player) {

//        int playerGameScoreIndex = 1 + player;
//        int playerSetScoreIndex = -1 + player;
//        int gameScoreValue = score.elementAt(playerGameScoreIndex);
//        gameScoreValue++;

        int player1SetScore = score.elementAt(0);
        int player2SetScore = score.elementAt(1);
        int player1GameScore = score.elementAt(2);
        int player2GameScore = score.elementAt(3);

        if (player == 1) {
            player1GameScore++;

            // Game score reset if game is won
            if (player1GameScore == 4) {
                if (player2GameScore < 3) {
                    player1GameScore = 0;
                    player2GameScore = 0;
                    player1SetScore++;
                }

                else if (player2GameScore == 4) {
                    player2GameScore = 3;
                }
            }

            if (player1GameScore == 5) {
                player1SetScore++;
                player1GameScore = 0;
                player2GameScore = 0;
            }

        }
        else if (player == 2) {
            player2GameScore++;

            // Game score reset if game is won
            if (player2GameScore == 4) {
                if (player1GameScore < 3) {
                    player2GameScore = 0;
                    player1GameScore = 0;
                    player2SetScore++;
                }

                else if (player1GameScore == 4) {
                    player1GameScore = 3;
                }
            }

            if (player2GameScore == 5) {
                player2SetScore++;
                player2GameScore = 0;
                player1GameScore = 0;
            }
        }

        score.setElementAt(new Integer(player1SetScore),0);
        score.setElementAt(new Integer(player2SetScore),1);
        score.setElementAt(new Integer(player1GameScore),2);
        score.setElementAt(new Integer(player2GameScore),3);

        return printScore();
//        return "0-0 15-0";
    }

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

        return sb.toString();
    }

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
