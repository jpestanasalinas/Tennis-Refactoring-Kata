
public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.name) {
            player1.addPoint();
        } else {
            player2.addPoint();
        }
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
            String player1ScoreName = playerScoreName(player1.score);
            String player2ScoreName = playerScoreName(player2.score);

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
        return player1.exceedsFiftyThreshold() || player2.exceedsFiftyThreshold();
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
        return player1.scoreDifferenceWith(player2);
    }

    private String draftScore() {
        return switch (player1.score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private boolean draft() {
        return player1.sameScore(player2);
    }
    public static class Player {
        private final String name;
        private int score;

        public Player(String name) {
            this.score = 0;
            this.name = name;
        }

        public boolean sameScore(Player other) {
            return this.score == other.score;
        }

        public int scoreDifferenceWith(Player other) {
            return this.score - other.score;
        }

        public void addPoint() {
            this.score++;
        }

        public boolean exceedsFiftyThreshold() {
            return this.score >= 4;
        }
    }

}
