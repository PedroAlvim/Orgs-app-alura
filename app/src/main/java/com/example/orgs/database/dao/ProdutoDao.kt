package com.example.orgs.database.dao

import androidx.room.*
import com.example.orgs.model.Produtos

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produtos")
    fun buscaTodos() : List<Produtos>

    @Insert
    fun salva(produtos: Produtos)

    @Delete
    fun remove(produtos: Produtos)

    @Update
    fun altera(produtos: Produtos)
}