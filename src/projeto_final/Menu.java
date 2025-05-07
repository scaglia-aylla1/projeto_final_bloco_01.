package projeto_final;

import java.io.IOException;
import java.util.Scanner;

import projeto_final.util.Cores;

public class Menu {
    public static void main(String[] args) {
    	
    	
        Scanner leia = new Scanner(System.in);
		int opcao;
		while(true) {
 
			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+          "******************************************************\n"
					+          "******************************************************");
			System.out.println("*                                                    *");
			System.out.println("*               LIVRARIA LETRAS VIVAS                *");
			System.out.println("*                                                    *");
			System.out.println("******************************************************");
			System.out.println("*                                                    *");
			System.out.println("*           1 - Cadastrar Livro                      *");
			System.out.println("*           2 - Listar Livros Disponíveis            *");
			System.out.println("*           3 - Buscar Livro por ID                  *");
			System.out.println("*           4 - Atualizar Dados do Livro             *");
			System.out.println("*           5 - Apagar Livro                         *");
			System.out.println("*           6 - Sair                                 *");
			System.out.println("*                                                    *");
			System.out.println("******************************************************");
			System.out.println("   Entre com a opção desejada:                       *");
			System.out.println("                                                     *" + Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			if (opcao == 6) {
				System.out.println(Cores.TEXT_PURPLE_BOLD+ "\nLivraria Letras Vivas! Seu próximo universo começa aqui!!!");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Cadastrar Livro \n\n");
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar Livros Disponíveis\n\n");
					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Buscar Livro por ID\n\n");
					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar Dados do Livro\n\n");
					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar Livro\n\n");
					keyPress();
					break;
 
              
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					keyPress();
					break;
			}
		}	
    }
 
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Aylla Scaglia");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/scaglia-aylla1");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.err.println("Ocorreu um erro ao tentar ler o teclado");

		}
   }
 
}
