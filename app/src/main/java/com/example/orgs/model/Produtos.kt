package com.example.orgs.model

import java.math.BigDecimal

data class Produtos(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal,
    val imagem: String? = null
)
