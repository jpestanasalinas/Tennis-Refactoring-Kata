
public class TennisGame1 implements TennisGame {
    
    private int player1Scoring;
    private int player2Scoring;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        player1Scoring = 0;
        player2Scoring = 0;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Scoring += 1;
        else
            player2Scoring += 1;
    }

    public String getScore() {
        String score = "";
        if (draft()) {
            return draftScore();
        } else if ((player1Scoring >=4 || player2Scoring >=4) && Math.abs(player1Scoring - player2Scoring)==1) {
            int minusResult = player1Scoring - player2Scoring;
            if (minusResult==1) return "Advantage player1";
            else return "Advantage player2";
        } else if (player1Scoring >=4 || player2Scoring >=4) {
            int minusResult = player1Scoring - player2Scoring;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        } else {
            int tempScore;
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Scoring;
                else { score+="-"; tempScore = player2Scoring;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
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
}
