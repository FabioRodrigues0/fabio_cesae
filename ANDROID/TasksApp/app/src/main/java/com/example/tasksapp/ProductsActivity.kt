package com.example.tasksapp

import android.R
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tasksapp.databinding.ActivityProductsBinding
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import java.io.Serializable

class ProductsActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityProductsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonVoltar.setOnClickListener {
            finish()
        }

        val sharedPreferences = this.getSharedPreferences("listProducts", Context.MODE_PRIVATE)
        val sharedProducts = sharedPreferences.getString("listProducts", "").toString()

        val listProducts = ArrayList<String>()

        val product = sharedProducts
            .replace("[", "")
            .replace("]", "")
            .replace("\"", "")
            .split(",")

        product.mapIndexed { index, value -> "$index -> ${listProducts.add(value.trim())}" }

        binding.listProducts.adapter = ArrayAdapter(this, R.layout.simple_list_item_1, listProducts)

        binding.buttonAddProduct.setOnClickListener {
            val product = binding.textAddProduct.text.toString()
            if (!listProducts.contains(product)) {
                listProducts.add(product)

                val listaProdutosWithIndex = listProducts.mapIndexed { index, value -> "$index -> $value" }
                binding.listProducts.adapter =
                    ArrayAdapter(this,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaProdutosWithIndex)

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("listProducts", listProducts.toString())
                editor.apply()
            } else {
                Toast.makeText(this, "Produto $product já se encontra na lista", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.buttonRemoveProduct.setOnClickListener {
            val product = binding.textRemoveProduct.text.toString()
            if (listProducts.contains(product)) {

                listProducts.remove(product)
                val listaProdutosWithIndex = listProducts.mapIndexed { index, value -> "$index -> $value" }
                binding.listProducts.adapter =
                    ArrayAdapter(this,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaProdutosWithIndex)

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("listProducts", listProducts.toString())
                editor.apply()
            } else {
                Toast.makeText(this, "Produto $product não encontrado", Toast.LENGTH_SHORT).show()
            }

        }

    }
}