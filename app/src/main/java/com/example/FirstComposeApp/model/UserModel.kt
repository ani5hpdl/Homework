package com.example.FirstComposeApp.model

data class UserModel(
    val userId: String ="",
    val email: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val password: String = "",
    val dob: String = "",
){
    fun toMap(): Map<String,Any?>{
        return mapOf(
            "userId" to userId,
            "email" to email,
            "firstName" to firstName,
            "lastName" to lastName,
            "password" to password,
            "dob" to dob
        )
    }
}

