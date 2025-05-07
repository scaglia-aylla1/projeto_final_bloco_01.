package projeto_final.model;

public class Fisico extends Livros{

	private float frete;

	public Fisico(int id, String nome, String autor, int tipo, float preco, float frete) {
		super(id, nome, autor, tipo, preco);
		this.frete = frete;
		
	}

	public float getFrete() {
		return frete;
	}

	public void setFrete(float frete) {
		this.frete = frete;
	}
	@Override
	public float precoFinal() {
		return this.getPreco() + frete;
	}
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Frete: " + this.frete);
		System.out.println("Preço final: " + precoFinal());
		
	}
	
	
}
