import java.util.*;

public class ac1 {

	public static char[][] initialize() {
		char tabuleiro[][] = new char[3][3];

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[0].length; j++) {
				tabuleiro[i][j] = '-';
				System.out.print(tabuleiro[i][j] + "\t");
			}
			System.out.println();
		}
		return tabuleiro;
	}

	public static boolean step(char M[][], int linha, int col, char gamer) {

		if (M[linha][col] == 'X' || M[linha][col] == 'O') {
			return false;
		} else {
			M[linha][col] = gamer;
			return true;
		}
	}

	public static int status(char M[][]) {
		int status = -1;

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][0] == 'X' && M[i][1] == 'X' && M[i][2] == 'X') {
					status = 2;
					return status;
				} else if (M[i][0] == 'O' && M[i][1] == 'O' && M[i][2] == 'O') {
					status = 1;
					return status;
				} else if (M[0][j] == 'X' && M[1][j] == 'X' && M[2][j] == 'X') {
					status = 2;
					return status;
				} else if (M[0][j] == 'O' && M[1][j] == 'O' && M[2][j] == 'O') {
					status = 1;
					return status;
				} else if (M[0][0] == 'X' && M[1][1] == 'X' && M[2][2] == 'X') {
					status = 2;
					return status;
				} else if (M[0][0] == 'O' && M[1][1] == 'O' && M[2][2] == 'O') {
					status = 1;
					return status;
				} else if (M[0][2] == 'X' && M[1][1] == 'X' && M[2][0] == 'X') {
					status = 2;
					return status;
				} else if (M[0][2] == 'O' && M[1][1] == 'O' && M[2][0] == 'O') {
					status = 1;
					return status;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j] == '-') {
					count++;
				}
			}
		}

		if (count == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	public static void imprimeTabuleiro(char M[][]) {
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				System.out.print(M[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char tabuleiro[][] = initialize();
		int linha;
		int coluna;

		Scanner entrada = new Scanner(System.in);

		while (status(tabuleiro) == -1) {
			System.out.println("Jogador O insira uma linha e uma coluna: ");
			linha = entrada.nextInt();
			coluna = entrada.nextInt();
			if (linha > 2 || coluna > 2) {
				System.out.println("As linhas e colunas devem ter os valores entre 0 e 2");
			} else {
				step(tabuleiro, linha, coluna, 'O');
			}

			if (status(tabuleiro) == -1) {
				imprimeTabuleiro(tabuleiro);
				System.out.println("Jogador X insira uma linha e uma coluna: ");
				linha = entrada.nextInt();
				coluna = entrada.nextInt();
				if (linha > 2 || coluna > 2) {
					System.out.println("As linhas e colunas devem ter os valores entre 0 e 2");
				} else {
					step(tabuleiro, linha, coluna, 'X');
				}
				imprimeTabuleiro(tabuleiro);
			}
		}
		System.out.println("-------------------------------");
		System.out.println("Fim do jogo");
		System.out.println("-------------------------------");
		imprimeTabuleiro(tabuleiro);
		if (status(tabuleiro) == 0) {
			System.out.println("Empate");
		} else if (status(tabuleiro) == 1) {
			System.out.println("O jogador O venceu");
		} else {
			System.out.println("O jogador X venceu");
		}

		entrada.close();
	}
}
