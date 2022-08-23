package com.example.orgs.dao


import com.example.orgs.model.Produtos
import java.math.BigDecimal

class ProdutosDao {

    fun adiciona(produto: Produtos) {
        produtos.add(produto)
    }


    fun buscaTodos(): List<Produtos> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produtos>(
            Produtos(
                nome = "Salada de frutas",
                descricao = "Maça, laranja, Abacaxi",
                valor = BigDecimal("19.99")
            )
        )
    }
}
