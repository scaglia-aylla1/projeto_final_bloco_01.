package projeto_final.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final.model.Livros;
import projeto_final.repository.LivrosRepository;

public class LivrosController implements LivrosRepository{
	
	private ArrayList<Livros> listarLivros = new ArrayList<Livros>();
	int id = 0;

	@Override
	public void buscarPorId(int id) {
		Optional<Livros> livros = buscarNaCollection(id);
		
		if (livros.isPresent())
			livros.get().visualizar();
		else
			System.out.printf("\nO Livro de ID número %d não foi encontrado", id);
		
	}

	@Override
	public void listarTodos() {
		for(var livro : listarLivros) {
			livro.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Livros livro) {
		listarLivros.add(livro);
		System.out.println("O Livro foi cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Livros livros) {
		Optional<Livros> buscaLivros = buscarNaCollection(livros.getId());

		if (buscaLivros.isPresent()) {
			listarLivros.set(listarLivros.indexOf(buscaLivros.get()), livros);
			System.out.printf("\nO Produto ID %d foi atualizado com sucesso!", livros.getId());
		} else
			System.out.printf("\nO Produto ID %d não foi encontrado", livros.getId());

	}

	@Override
	public void deletar(int id) {
		Optional<Livros> livro = buscarNaCollection(id);

		if (livro.isPresent()) {
			if (listarLivros.remove(livro.get()) == true)
				System.out.printf("\nO Produto ID %d foi excluído com sucesso!", id);
		} else
			System.out.printf("\nO Produto ID %d não foi encontrado", id);
		
	}
	
	public int gerarId() {
		return ++id;
	}
	
	public Optional<Livros> buscarNaCollection(int id) {
		for (var livro : listarLivros) {
			if (livro.getId() == id)
				return Optional.of(livro);
		}

		return Optional.empty();
	}

}
