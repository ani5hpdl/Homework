package com.example.FirstComposeApp.model

data class ProductModel(
    var productId : String = "",
    var productName : String = "",
    var productQuantity : String = "",
    var productRate : String = "",
    var image : String = ""
){
    fun toMap(): Map<String,Any?>{
        return mapOf(
            "productName" to productName,
            "productQuantity" to productQuantity,
            "productRate" to productRate
        )
    }
}
