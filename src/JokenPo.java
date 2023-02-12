import java.util.Random;
import java.util.Scanner;

public record JokenPo(
        Player user,
        Player IA,
        int rounds
) {
    public void toPlay() {
        System.out.println("\n ******* SEJA BEM-VINDO, " + user.getName() + " *******\n");

        for (int i = 1; i <= rounds; i++) {
            System.out.println("Round " + i);
            int choiceUser = choiceUser();
            if (choiceUser < 1 || choiceUser > 3) {
                System.out.println("\nJOGADA INVÁLIDA! (1, 2 OU 3): ");
                System.out.println("\t\tPONTO PARA " + IA.getName() + "\n");
                IA.incrementScore();
                continue;
            }
            int choiceIA = choiceIA();

            System.out.print("\n" + choiceUser + " X " + choiceIA);

            int result = choiceUser - choiceIA;
            winnerRound(result);
        }
    }

    public void showFinalResult() {
        System.out.println("**********************************");
        int finalScoreUser = user.getScore();
        int finalScoreIA = IA.getScore();

        System.out.println("\n\tPLACAR FINAL: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());

        if (finalScoreUser == finalScoreIA) {
            System.out.println("\t\t\tEMPATE!\n");
        } else {
            String finalWinner = (finalScoreUser > finalScoreIA) ? user.getName() : IA.getName();
            System.out.println("\t\tVENCEDOR = " + finalWinner.toUpperCase() + "\n");
        }
        System.out.println("**********************************");

    }

    private void winnerRound(int result) {
        String winnerRound;
        if (result == 0) {
            winnerRound = "EMPATE!";
        } else if (result == -1 || result == 2) {
            IA.incrementScore();
            winnerRound = IA.getName();
        } else {
            user.incrementScore();
            winnerRound = user.getName();
        }
        System.out.println("\nVencedor do Round: " + winnerRound + "\n");
    }

    private int choiceIA() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    private int choiceUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - PEDRA ");
        System.out.println("2 - PAPEL ");
        System.out.println("3 - TESOURA ");

        System.out.print("Informe sua jogada: ");
        return scan.nextInt();
    }

}
