
public class TennisGame3 implements TennisGame {

    private static final String[] SCORE_NAMES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private int pointsPlayer1;
    private int pointsPlayer2;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (pointsPlayer1 < 4 && pointsPlayer2 < 4 && !(pointsPlayer1 + pointsPlayer2 == 6)) {
            String score = SCORE_NAMES[pointsPlayer1];
            if (pointsPlayer1 == pointsPlayer2)
                return score + "-All";
            return score + "-" + SCORE_NAMES[pointsPlayer2];
        } else {
            if (pointsPlayer1 == pointsPlayer2) {
                return "Deuce";
            }
            String leader = pointsPlayer1 > pointsPlayer2 ? player1Name : player2Name;
            if ((pointsPlayer1 - pointsPlayer2) * (pointsPlayer1 - pointsPlayer2) == 1)
                return "Advantage " + leader;
            return "Win for " + leader;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.pointsPlayer1 += 1;
        else
            this.pointsPlayer2 += 1;
        
    }

}
