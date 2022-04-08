package com.dimaf.voicediary.domain


data class Voice (
    val id : Int = UNDEFINED_ID,
    val date : String,
    val fileUrl : String
        ) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}