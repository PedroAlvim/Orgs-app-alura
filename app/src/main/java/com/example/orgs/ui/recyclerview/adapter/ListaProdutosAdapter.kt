package com.example.orgs.ui.recyclerview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.databinding.ProdutoItemBinding
import com.example.orgs.model.Produtos

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produtos>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val nome = binding.produtoItemNome
        private val descricao = binding.produtoItemDescricao
        private val valor = binding.produtoItemValor

        fun vincula(produto: Produtos) {

            nome.text = produto.nome
            descricao.text = produto.descricao
            valor.text = produto.valor.toPlainString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ProdutoItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)

    }

    override fun getItemCount(): Int = produtos.size

    @SuppressLint("NotifyDataSetChanged")
    fun atualiza(produtos: List<Produtos>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }
}
