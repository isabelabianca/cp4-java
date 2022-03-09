package jogoDaVelha;

/*
	FIAP 
	TADS - 2o semestre de 2021

	Prof. Fernando Almeida  
	Checkpoint DDD
	
	Arquivo: <nome do arquivo>
	Caio Lizeo Soares 							87809
	Isabela Bianca Correa de Macedo				88493
	Jonatan Jacó Mascalhusk De Oliveira Souza	88221
	Lucas Amorim Marques Pereira				84659
	Rodrigo Gonzalo Barbosa Segura				83954
	
	Data de entrega: 19/09/2021
*/

public class Teste {
	public static void main(String[] args) {
		JogoDaVelha teste = new JogoDaVelha();
		
		boolean fim = false;
		
		while (fim == false) {
			int opcao = teste.imprimeMenuPrincipal();
			
			switch (opcao){
				case 1: 
					teste.modoJogador();
					break;
				case 2: 
					System.out.println("\nEm construção");
					break;
				case 3: 
					System.out.println("\nEm construção");
					break;
				case 4: 
					System.out.println("\nAté mais :) ");
					fim = true;
					break;
			}
		}
	}
}
