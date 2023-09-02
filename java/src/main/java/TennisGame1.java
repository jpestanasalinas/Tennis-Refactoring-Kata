
public class TennisGame1 implements TennisGame {
    
    private int player1Scoring;
    private int player2Scoring;
    private String player1Name;
    private String player2Name;

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        player1Scoring = 0;
        player2Scoring = 0;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Scoring += 1;
        else
            player2Scoring += 1;
    }

    public String getScore() {
        if (finishedGame()) {
            if (player1ScoreDifference() >= 2) return "Win for player1";
            return "Win for player2";
        } else if (draft()) {
            return draftScore();
        } else if (advantagePhase()) {
            if (player1ScoreDifference() == 1) return "Advantage player1";
            return "Advantage player2";
        } else {
            String player1ScoreName = playerScoreName(player1Scoring);
            String player2ScoreName = playerScoreName(player2Scoring);

            return player1ScoreName + "-" + player2ScoreName;
        }
    }

    private boolean advantagePhase() {
        return somePlayerExceedsFiftyThreshold() && Math.abs(player1ScoreDifference()) == 1;
    }

    private boolean finishedGame() {
        return somePlayerExceedsFiftyThreshold() && Math.abs(player1ScoreDifference()) > 1;
    }

    private boolean somePlayerExceedsFiftyThreshold() {
        return player1Scoring >= 4 || player2Scoring >= 4;
    }

    private String playerScoreName(int playerScoring) {
        return switch (playerScoring) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException();
        };
    }

    private int player1ScoreDifference() {
        return player1Scoring - player2Scoring;
    }

    private String draftScore() {
        return switch (player1Scoring) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private boolean draft() {
        return player1Scoring == player2Scoring;
    }
    public class Player {
        private final String name;
        private int score;

        public Player(String name) {
            this.score = 0;
            this.name = name;
        }
    }

}
