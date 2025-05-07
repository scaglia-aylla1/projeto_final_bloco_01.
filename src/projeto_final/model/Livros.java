package projeto_final.model;

import java.text.NumberFormat;

public class Livros {
	
	private int id;
	private String nome;
	private String autor;
	private int tipo;
	private float preco;
	
	
	


	public Livros(int id, String nome, String autor, int tipo, float preco) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.tipo = tipo;
		this.preco = preco;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public float precoFinal() {
		return preco;
	}


	public void visualizar() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Físico";
		case 2 -> tipo = "Ebook";
		default -> tipo = "Inválido";
		}

		System.out.println("***************************************");
		System.out.println("DADOS DO LIVRO                        ");
		System.out.println("***************************************");
		System.out.println("ID do Livro: " + this.id);
		System.out.println("Nome do Livro: " + this.nome);
		System.out.println("Nome do Livro: " + this.autor);
		System.out.println("Tipo do Livro: " + tipo);
		System.out.println("Preço do Livro: " + nfMoeda.format(this.preco));
	}
	

}
