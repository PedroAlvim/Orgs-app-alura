package com.example.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.database.AppDatabase
import com.example.orgs.databinding.ActivityFormularioProdutoBinding
import com.example.orgs.extensions.tentaCarregarImagem
import com.example.orgs.model.Produtos
import com.example.orgs.ui.dialog.FormularioImagemDialog
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    private var url: String? = null
    private var idProduto = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar Produto"

        configuraBotaoSalvar()

        binding.activityFormularioProdutoImagem.setOnClickListener {
            FormularioImagemDialog(this).mostra(url) { imagem ->
                url = imagem
                binding.activityFormularioProdutoImagem.tentaCarregarImagem(url)
            }
        }

        intent.getParcelableExtra<Produtos>(CHAVE_PRODUTO)?.let { produtoCarregado ->
            title = "Alterar produto"
            idProduto = produtoCarregado.id
            url = produtoCarregado.imagem
            binding.activityFormularioProdutoImagem.tentaCarregarImagem(produtoCarregado.imagem)
            binding.activityFormularioProdutoNome.setText(produtoCarregado.nome)
            binding.activityFormularioProdutoDescricao.setText(produtoCarregado.descricao)
            binding.activityFormularioProdutoValor.setText(produtoCarregado.valor.toPlainString())
        }
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvar
        val db = AppDatabase.instancia(this)
        val produtoDao = db.produtoDao()

        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            if(idProduto > 0){
                produtoDao.altera(produtoNovo)
            }else{
                produtoDao.salva(produtoNovo)
            }
            finish()
        }
    }

    private fun criaProduto(): Produtos {
        val campoNome = binding.activityFormularioProdutoNome
        val nome = campoNome.text.toString()
        val campoDescricao = binding.activityFormularioProdutoDescricao
        val descricao = campoDescricao.text.toString()
        val campoValor = binding.activityFormularioProdutoValor
        val valorEmTexto = campoValor.text.toString()

        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produtos(
            id = idProduto,
            nome = nome,
            descricao = descricao,
            valor = valor,
            imagem = url
        )
    }

}