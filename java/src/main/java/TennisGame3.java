
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
        if (!isEndGame()) {
            String score = SCORE_NAMES[pointsPlayer1];
            if (draft()) return score + "-All";
            return score + "-" + SCORE_NAMES[pointsPlayer2];
        } else {
            if (draft()) return "Deuce";
            if (isAdvantagePhase()) return "Advantage " + leader();
            return "Win for " + leader();
        }
    }

    private boolean draft() {
        return pointsPlayer1 == pointsPlayer2;
    }

    private boolean isAdvantagePhase() {
        return (pointsPlayer1 - pointsPlayer2) * (pointsPlayer1 - pointsPlayer2) == 1;
    }

    private String leader() {
        return pointsPlayer1 > pointsPlayer2 ? player1Name : player2Name;
    }

    private boolean isEndGame() {
        return !(pointsPlayer1 < 4 && pointsPlayer2 < 4 && !(pointsPlayer1 + pointsPlayer2 == 6));
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.pointsPlayer1 += 1;
        else
            this.pointsPlayer2 += 1;
        
    }

}
