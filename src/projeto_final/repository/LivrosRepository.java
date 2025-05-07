package projeto_final.repository;

import projeto_final.model.Livros;

public interface LivrosRepository {
	
	public void buscarPorId(int id);
	public void listarTodos();
	public void cadastrar(Livros livro);
	public void atualizar(Livros livro);
	public void deletar(int id);

}
