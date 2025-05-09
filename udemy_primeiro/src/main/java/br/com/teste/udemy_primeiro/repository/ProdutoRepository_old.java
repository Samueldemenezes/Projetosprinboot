package br.com.teste.udemy_primeiro.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.teste.udemy_primeiro.model.Produto;

@Repository

public class ProdutoRepository_old {
    
    // Simulando um banco de dados
    private List <Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retornar uma lista de produtos
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }
/**
 * Metodo que retorna o produto encontrado pelo seu id
 * @param id do produto que será localizado
 * @return retorna um produto seja caso tenha encontrado
 */
    public Optional<Produto> obterPorId(Integer id){
    return produtos
        .stream()
        .filter(produto -> produto.getId()== id)
        .findFirst();
    }
/**
 * Metodo para adicionar produto na lista.
 * @param produto que sera adicionado.
 * @return retorna o produto que foi adicionado na lista.
 */
    public Produto adicionar(Produto produto){
        
        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

/**
 * Metodo para deletar o produto por id.
 * @param id do produto a ser deletado.
 */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }
/**
 * Metodo para atulaizar o produto na lista
 * @param produto que será atualizado.
 * @return produto após atualizar a lista.
*/
    public Produto atualizar (Produto produto){
        Optional<Produto> produtoEncontrado=obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }

        deletar(produto.getId());

        produtos.add(produto);

        return produto;
    }

}