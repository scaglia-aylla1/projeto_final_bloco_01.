package projeto_final;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final.controller.LivrosController;
import projeto_final.model.Ebook;
import projeto_final.model.Fisico;
import projeto_final.model.Livros;
import projeto_final.util.Cores;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		LivrosController livros = new LivrosController();
		int opcao, id, tipo;
		String nome, autor, fisico, ebook, formato;
		float preco, frete;

		Fisico l1 = new Fisico(livros.gerarId(), "Orgulho e Preconceito", "Jane Austen", 1, 18.79f, 10.55f);
		livros.cadastrar(l1);
		Fisico l2 = new Fisico(livros.gerarId(), "Pequena Loja de venenos", "Sarah Penner", 1, 37.44f, 5.99f);
		livros.cadastrar(l2);

		Ebook l3 = new Ebook(livros.gerarId(), "Chocolate quente ás quinta-feiras", "Michiko Aoyama", 2, 34.60f, "PDF");
		livros.cadastrar(l3);
		Ebook l4 = new Ebook(livros.gerarId(), "A Cirurgiã", "Leslie Wolfe", 2, 34.60f, "Kindle");
		livros.cadastrar(l4);

		while (true) {

			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "******************************************************\n"
					+ "******************************************************");
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
				System.out.println(
						Cores.TEXT_PURPLE_BOLD + "\nLivraria Letras Vivas! Seu próximo universo começa aqui!!!");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Cadastrar Livro \n\n");

				System.out.println("Digite o nome do Livro:");
				leia.skip("\\R");
				nome = leia.nextLine();

				System.out.println("Digite o autor do Livro:");
				autor = leia.nextLine();

				System.out.println("Digite o tipo do Livro (1 - FÍSICO| 2 - EBOOK:");
				tipo = leia.nextInt();

				System.out.println("Digite o preço do Livro:");
				preco = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Valor do Frete:");
					leia.skip("\\R");
					frete = leia.nextFloat();
					livros.cadastrar(new Fisico(livros.gerarId(), nome, autor, tipo, preco, frete));
				}
				case 2 -> {
					System.out.println("Digite o formato do livro: ");
					leia.skip("\\R");
					formato = leia.nextLine();
					livros.cadastrar(new Ebook(livros.gerarId(), nome, autor, tipo, preco, formato));
				}

				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar Livros Disponíveis\n\n");
				livros.listarTodos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar Livro por ID\n\n");
				System.out.println("Digite o ID do Livro: ");
				id = leia.nextInt();

				livros.buscarPorId(id);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Dados do Livro\n\n");
				System.out.println("Digite o id do livro: ");
				id = leia.nextInt();

				Optional<Livros> livro = livros.buscarNaCollection(id);

				if (livro.isPresent()) {
					System.out.println("Digite o nome do Livro:");
					leia.skip("\\R");
					nome = leia.nextLine();

					System.out.println("Digite o autor do Livro:");
					autor = leia.nextLine();

					tipo = livro.get().getTipo();

					System.out.println("Digite o preço do Livro:");
					preco = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o valor do frete: ");
						leia.skip("\\R");
						frete = leia.nextFloat();
						livros.atualizar(new Fisico(id, nome, autor, tipo, preco, frete));
					}
					case 2 -> {
						System.out.println("Digite o formato:");
						leia.skip("\\R");
						formato = leia.nextLine();
						livros.atualizar(new Ebook(id, nome, autor, tipo, preco, formato));
					}
					}
				} else {
					System.out.printf("\n O Produto ID %d não existe!", id);
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar Livro\n\n");
				
				System.out.println("Digite o ID do Livro: ");
				id = leia.nextInt();

				livros.deletar(id);
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
