package com.example.orgs.database.dao

import androidx.room.*
import com.example.orgs.model.Produtos
import kotlinx.coroutines.flow.Flow

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produtos")
    fun buscaTodos(): Flow<List<Produtos>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun salva(produtos: Produtos)

    @Delete
    suspend fun remove(produtos: Produtos)

    @Query("SELECT * FROM Produtos WHERE id = :id")
    fun buscaPorId(id: Long): Flow<Produtos?>

    @Query("SELECT * FROM Produtos ORDER BY nome ASC")
    fun buscaTodosOrdenadorPorNomeAsc(): Flow<List<Produtos>>

    @Query("SELECT * FROM Produtos ORDER BY nome DESC")
    fun buscaTodosOrdenadorPorNomeDesc(): Flow<List<Produtos>>

    @Query("SELECT * FROM Produtos ORDER BY descricao ASC")
    fun buscaTodosOrdenadorPorDescricaoAsc(): Flow<List<Produtos>>

    @Query("SELECT * FROM Produtos ORDER BY descricao DESC")
    fun buscaTodosOrdenadorPorDescricaoDesc(): Flow<List<Produtos>>

    @Query("SELECT * FROM Produtos ORDER BY valor ASC")
    fun buscaTodosOrdenadorPorValorAsc(): Flow<List<Produtos>>

    @Query("SELECT * FROM Produtos ORDER BY valor DESC")
    fun buscaTodosOrdenadorPorValorDesc(): Flow<List<Produtos>>
}