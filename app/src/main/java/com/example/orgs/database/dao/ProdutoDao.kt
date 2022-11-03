package com.example.orgs.database.dao

import androidx.room.*
import com.example.orgs.model.Produtos

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produtos")
    fun buscaTodos(): List<Produtos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(produtos: Produtos)

    @Delete
    fun remove(produtos: Produtos)

    @Query("SELECT * FROM Produtos WHERE id = :id")
    fun buscaPorId(id: Long): Produtos?

    @Query("SELECT * FROM Produtos ORDER BY nome ASC")
    fun buscaTodosOrdenadorPorNomeAsc(): List<Produtos>

    @Query("SELECT * FROM Produtos ORDER BY nome DESC")
    fun buscaTodosOrdenadorPorNomeDesc(): List<Produtos>

    @Query("SELECT * FROM Produtos ORDER BY descricao ASC")
    fun buscaTodosOrdenadorPorDescricaoAsc(): List<Produtos>

    @Query("SELECT * FROM Produtos ORDER BY descricao DESC")
    fun buscaTodosOrdenadorPorDescricaoDesc(): List<Produtos>

    @Query("SELECT * FROM Produtos ORDER BY valor ASC")
    fun buscaTodosOrdenadorPorValorAsc(): List<Produtos>

    @Query("SELECT * FROM Produtos ORDER BY valor DESC")
    fun buscaTodosOrdenadorPorValorDesc(): List<Produtos>
}