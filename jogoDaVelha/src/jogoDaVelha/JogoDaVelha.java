package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
	
	public char[][] inicializarTabuleiro(){
		char[][] tabuleiro = new char[3][3];	
		return tabuleiro;
	}
	
	public char[][] imprimirTabuleiro(char[][] tabuleiro) {
		System.out.printf("\n\t      1    2    3\n");
		System.out.printf("\n\t1     %c | %c  | %c", tabuleiro[0][0], tabuleiro[0][1], tabuleiro[0][2]);
		System.out.printf("\n\t    ----|----|----");
		System.out.printf("\n\t2     %c | %c  | %c", tabuleiro[1][0], tabuleiro[1][1], tabuleiro[1][2]);
		System.out.printf("\n\t    ----|----|----");
		System.out.printf("\n\t3     %c | %c  | %c", tabuleiro[2][0], tabuleiro[2][1], tabuleiro[2][2]);
		return tabuleiro;
	}
		
	public int leiaCoordenadaLinha() {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("\n\nDigite a coordenada da linha\n--> ");
		int linha = input.nextInt();
		
		while (linha < 1 || linha > 3) {
			System.out.printf("\n\nLinha inválida. Digite uma posição válida\n--> ");
			linha = input.nextInt();
		}
		
		return linha-1;
	}
	
	public int leiaCoordenadaColuna() {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("\nDigite a coordenada da coluna\n--> ");
		int coluna = input.nextInt();
		
		while (coluna < 1 || coluna > 3) {
			System.out.printf("\n\nColuna inválida. Digite uma posição válida\n--> ");
			coluna = input.nextInt();
		}
		
		return coluna-1;
	}
	
	public boolean posicaoValida(char[][] tabuleiro, int linha, int coluna) {
		boolean valido = true;
		
		if (tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O') {
			valido = false;
		}
		return valido;
	}
	
	public boolean verificaVencedor(char[][] tabuleiro) {
		boolean ganhou = false;
		
		// Verifica horizontais
		for (int i=0; i<3; i++) {
			int contX = 0;
			int contO = 0;
			for (int j=0; j<3; j++) {
				if (tabuleiro[i][j] == 'X') {
					contX++;
				}
				if (contX == 3) {
					ganhou = true;
				}
				if (tabuleiro[i][j] == 'O') {
					contO++;
				}
				if (contO == 3) {
					ganhou = true;
				}
			}
		}
		
		// Verifica verticais
		for (int i=0; i<3; i++) {
			int contX = 0;
			int contO = 0;
			for (int j=0; j<3; j++) {
				if (tabuleiro[j][i] == 'X') {
					contX++;
				}
				if (contX == 3) {
					ganhou = true;
				}
				if (tabuleiro[j][i] == 'O') {
					contO++;
				}
				if (contO == 3) {
					ganhou = true;
				}
			}
		}
		
		if (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2]== 'X'){
			ganhou = true;
		}
		if (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0]== 'X'){
			ganhou = true;
		}
		
		if (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2]== 'O'){
			ganhou = true;
		}
		if (tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0]== 'O'){
			ganhou = true;
		}
		
		return ganhou;
	}
	
	public int [] jogar() {
		int linha = leiaCoordenadaLinha();
		int coluna = leiaCoordenadaColuna();
			
		int []posicao = {linha, coluna};
		
		return  posicao;
	}
	
	public void modoJogador() {
		Scanner input = new Scanner(System.in);
		int linha, coluna, jogadas, contX, contO, contRodada;
		int vez = 1;
		boolean rodada = true;
		contRodada = 1;
		contX =0;
		contO =0;
		String jogador = "";
		
		System.out.println("Jogador 1, digite seu nome\n--> ");
		String jogador1 = input.next();
		
		System.out.println("Jogador 2, digite seu nome\n--> ");
		String jogador2 = input.next();
		
		while (rodada) {
			
			System.out.printf("\n\nRodada %d", contRodada);
			System.out.println("\n---------");
			
			char tabuleiro[][] = inicializarTabuleiro();
			imprimirTabuleiro(tabuleiro);
			vez = 1;
			jogadas = 0;
			
			while (jogadas < 9) {
				int[]posicao = jogar();
				linha = posicao[0];
				coluna = posicao[1];
				
				while (posicaoValida(tabuleiro, linha, coluna) == false){
					System.out.printf("\nPosição já utilizada");
					posicao = jogar();
					linha = posicao[0];
					coluna = posicao[1];
				}
				
				if (vez%2 == 1) {
					jogador = jogador1;
					tabuleiro[linha][coluna]= 'X';
				} else {
					tabuleiro[linha][coluna]= 'O';
					jogador = jogador2;
				}
				
				if (verificaVencedor(tabuleiro) == true) {
					imprimirTabuleiro(tabuleiro);
					if(vez%2 == 1) {
						contX++;
					}
					else {
						contO++;
					}
					System.out.printf("\n\nParabéns, %s, você ganhou essa rodada!", jogador);
					break;
				}
				
				imprimirTabuleiro(tabuleiro);
				vez++;
				jogadas++;				
			}
			
			//Esse item será alterado e aprimorado para o método verificaVelha na próxima entrega
			if (jogadas == 9) {
				System.out.println("\n\nOops, deu velha! ");  
			}
			
			contRodada++;
			if (contX==3 || contO ==3) {
				rodada= false;
				System.out.printf("\n\nParabéns, %s, você ganhou a partida!", jogador);
			}	
		}
	}
	
	public int imprimeMenuPrincipal() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("------------------------------------");
		System.out.println("                Menu				");
		System.out.println("------------------------------------");
		System.out.println("1 - Jogador vs Jogador				");
		System.out.println("2 - Jogador vs Máquina (fácil)   	");
		System.out.println("3 - Jogador vs Máquina (difícil)	");
		System.out.println("4 - Sair	");
		System.out.println("------------------------------------");
		
		System.out.printf("Escolha o modo de jogo --> ");
		int opcao = input.nextInt();
		
		while (opcao < 1 || opcao > 4) {
			System.out.printf("Opção inválida, digite novamente\n--> ");
			opcao = input.nextInt();
		}
		
		return opcao;
	}

}
