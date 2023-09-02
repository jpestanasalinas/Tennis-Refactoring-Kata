
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
        String s;
        if (pointsPlayer1 < 4 && pointsPlayer2 < 4 && !(pointsPlayer1 + pointsPlayer2 == 6)) {
            s = SCORE_NAMES[pointsPlayer1];
            return (pointsPlayer1 == pointsPlayer2) ? s + "-All" : s + "-" + SCORE_NAMES[pointsPlayer2];
        } else {
            if (pointsPlayer1 == pointsPlayer2)
                return "Deuce";
            s = pointsPlayer1 > pointsPlayer2 ? player1Name : player2Name;
            return ((pointsPlayer1 - pointsPlayer2)*(pointsPlayer1 - pointsPlayer2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.pointsPlayer1 += 1;
        else
            this.pointsPlayer2 += 1;
        
    }

}
