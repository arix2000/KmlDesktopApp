package com.example.controllers

import com.example.externalDbOperations.DbGetWorksHistory
import com.example.models.WorkHistory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WorksHistoryController {

    fun getWorksHistory(): List<WorkHistory>
    {
        val dbGetWorksHistory = DbGetWorksHistory()
        dbGetWorksHistory.start()
        val historyJson = dbGetWorksHistory.result

        return createListFromJson(historyJson)
    }

    private fun createListFromJson(historyJson: String): List<WorkHistory> {
        val gson = Gson()
        val type = object : TypeToken<List<WorkHistory>>() {}.type
        return gson.fromJson(historyJson, type) ?: listOf()
    }
}