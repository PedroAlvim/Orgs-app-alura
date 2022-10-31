package com.example.orgs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.orgs.model.Produtos

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produtos")
    fun buscaTodos() : List<Produtos>

    @Insert
    fun salva(produtos: Produtos)
}