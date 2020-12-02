package com.example.controllers

import com.example.externalDbOperations.DbGetWorksHistory
import com.example.models.HistoryWork
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WorksHistoryController {

    fun getWorksHistory(): List<HistoryWork>
    {
        val dbGetWorksHistory = DbGetWorksHistory()
        dbGetWorksHistory.start()
        val historyJson = dbGetWorksHistory.result

        return createListFromJson(historyJson)
    }

    private fun createListFromJson(historyJson: String): List<HistoryWork> {
        val gson = Gson()
        val type = object : TypeToken<List<HistoryWork>>() {}.type
        return gson.fromJson(historyJson, type) ?: listOf()
    }
}