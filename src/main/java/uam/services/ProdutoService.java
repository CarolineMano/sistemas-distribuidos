package uam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import uam.entities.Produto;
import uam.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto salvarProduto(Produto produto, long idUsuario) {
		produto.setId_usuario(idUsuario);
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listarEstoque() {
		return produtoRepository.findAll();
	}

	public Produto buscarProduto(Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		return optional.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
	}
	
	public Produto atualizarProduto(Produto produto, long id, long idUsuario) {
		Produto produtoOriginal = this.buscarProduto(id);
		produto.setId(produtoOriginal.getId());
		produto.setId_usuario(idUsuario);
		
		return produtoRepository.save(produto);
	}

	public void excluirProduto(Long id) {
		Produto produtoOriginal = this.buscarProduto(id);
		produtoRepository.delete(produtoOriginal);
	}
}
