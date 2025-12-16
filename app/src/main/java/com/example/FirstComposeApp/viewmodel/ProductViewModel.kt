package com.example.FirstComposeApp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.FirstComposeApp.model.ProductModel
import com.example.FirstComposeApp.repository.ProductRepo

class ProductViewModel(val repo: ProductRepo) : ViewModel() {



    fun addProduct(model: ProductModel, callback:(Boolean, String) -> Unit){
        repo.addProduct(model, callback)
    }

    fun updateProduct(model: ProductModel,callback: (Boolean, String) -> Unit){
        repo.updateProduct(model,callback)
    }

    fun deleteProduct(productId:String,callback: (Boolean, String) -> Unit){
        repo.deleteProduct(productId ,callback)
    }

    fun getAllProduct(callback: (Boolean, String, List<ProductModel>?) -> Unit){
        repo.getAllProduct(callback)
    }

    fun getProductById(productId: String,callback: (Boolean, String, ProductModel?) -> Unit){
        repo.getProductById(productId,callback)
    }

    fun getProductByCategory(categoryId:String, callback: (Boolean, String, List<ProductModel>?) -> Unit){
        repo.getProductByCategory(categoryId,callback)
    }
}