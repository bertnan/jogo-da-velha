import java.util.Scanner;

public class jogoDaVelha {
    public static void main(String[] args) {
        int linha, coluna, jogador = 0;
        Scanner entrada = new Scanner(System.in);
        char[][] tabuleiro = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.println("Jogador 1 (X) vs Jogador 2 (O)");
        do {       
            if(jogador % 2 == 0) {
                System.out.println("Jogador 1 (X), é sua vez!");
                System.out.println("Digite as coordenadas da linha (1, 2 ou 3)");
                linha = entrada.nextInt() - 1;
                System.out.println("Digite as coordenadas da coluna (1, 2 ou 3)");
                coluna = entrada.nextInt() - 1;
                tabuleiro[linha][coluna] = 'X';
                if (tabuleiro[linha][coluna] != ' ') {
                    System.out.println("Posição já ocupada. Tente novamente.");
                    
                }
            } else {
                System.out.println("Jogador 2 (O), é sua vez!");
                System.out.println("Digite as coordenadas da linha (1, 2 ou 3)");
                linha = entrada.nextInt() - 1;
                System.out.println("Digite as coordenadas da coluna (1, 2 ou 3)");
                coluna = entrada.nextInt() - 1;
                tabuleiro[linha][coluna] = 'O';
                if (tabuleiro[linha][coluna] != ' ') {
                    System.out.println("Posição já ocupada. Tente novamente.");
                }
            }
            jogador++;

            exibirTabuleiro(tabuleiro);
        } while (verificarVencedor(tabuleiro) == ' ' && !verificarEmpate(tabuleiro));
        if (verificarVencedor(tabuleiro) == 'X') {
            System.out.println("Jogador 1 (X) venceu!");
        } else if (verificarVencedor(tabuleiro) == 'O') {
            System.out.println("Jogador 2 (O) venceu!");
        } else {
            System.out.println("Empate!");
        }
    }
    public static char exibirTabuleiro (char[][] tabuleiro) {
        System.out.println("Tabuleiro atual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        return ' ';
    }
    public static char verificarVencedor(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return tabuleiro[0][i];
            }
        }
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0];
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2];
        }
        return ' ';
    }
    public static boolean verificarEmpate(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public static char fazerJogada(char[][] tabuleiro, int linha, int coluna, char jogador) {
        if (tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = jogador;
            return jogador;
        } else {
            System.out.println("Posição já ocupada. Tente novamente.");
            return ' ';
        }
    }
}