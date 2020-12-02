package com.example.models

import com.google.gson.annotations.SerializedName

data class HistoryWork(@field:SerializedName("nazwaZadania") val workName: String,
                           @field:SerializedName("opisZadania") val workDescription: String,
                           @field:SerializedName("data") val date: String,
                           @field:SerializedName("czasWykonania") val executionTime: String)
