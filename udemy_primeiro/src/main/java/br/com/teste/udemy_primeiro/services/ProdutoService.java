package br.com.teste.udemy_primeiro.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.udemy_primeiro.model.Produto;
import br.com.teste.udemy_primeiro.repository.ProdutoRepository_old;

@Service

public class ProdutoService {

    @Autowired
    private ProdutoRepository_old produtoRepository;
    /**
     * Metodo para retornar uma lista de produtos 
     * @return Lista de produtos 
     */
    public List<Produto> obterTodos(){
        // Colocar regra caso tenha
        return produtoRepository.obterTodos();
    }
    /**
     * Metodo que retorna o produto encontrado pelo seu id
     * @param id do produto que será localizado
     * @return retorna um produto seja caso tenha encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }
    /**
     * Metodo para adicionar produto na lista.
     * @param produto que sera adicionado.
     * @return retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        // Colocar regra caso tenha
        return produtoRepository.adicionar(produto);
    }
    /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }
    /**
 * Metodo para atulaizar o produto na lista
 * @param produto que será atualizado.
 * @param id do produto
 * @return produto após atualizar a lista.
*/
    public Produto atualizar (Integer id, Produto produto){
        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }

}