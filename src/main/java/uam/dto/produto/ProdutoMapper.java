package uam.dto.produto;

import uam.entities.Produto;

public class ProdutoMapper {
	public static Produto fromDTO(RegistroProdutoDTO dto) {
		return new Produto(null, dto.getNome(), dto.getQuantidade(), dto.getValorUnitario(), null);
	}
	
	public static ConsultaProdutoDTO fromEntity(Produto produto) {
		return new ConsultaProdutoDTO(produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getValorUnitario(), produto.getId_usuario());
	}
}
