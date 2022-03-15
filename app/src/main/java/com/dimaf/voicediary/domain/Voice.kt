package com.dimaf.voicediary.domain

import java.time.LocalDateTime

data class Voice (
    val id : Int,
    val date : LocalDateTime,
    val fileUrl : String
        )