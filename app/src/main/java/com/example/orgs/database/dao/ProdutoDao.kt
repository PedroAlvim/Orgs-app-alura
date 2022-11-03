package com.example.orgs.database.dao

import androidx.room.*
import com.example.orgs.model.Produtos

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produtos")
    fun buscaTodos() : List<Produtos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(produtos: Produtos)

    @Delete
    fun remove(produtos: Produtos)

    @Query("SELECT * FROM Produtos WHERE id = :id")
    fun buscaPorId(id: Long) : Produtos?
}