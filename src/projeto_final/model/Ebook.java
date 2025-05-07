package projeto_final.model;

public class Ebook extends Livros{
	
	private String formato;
	
	

	public Ebook(int id, String nome, String autor, int tipo, float preco, String formato) {
		super(id, nome, autor, tipo, preco);
		this.formato = formato;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	@Override
	public float precoFinal() {
		return this.getPreco() - ((this.getPreco() * 10)/ 100);
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Formato: " + this.formato);
		System.out.println("Preço final: " + precoFinal());
		
	}
	
	

}
