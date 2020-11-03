package com.example.controllers

import com.example.app.GlobalVars
import com.example.models.Work
import com.example.externalDbOperations.DbSendWork
import tornadofx.isInt

class WorkTimerController {

    companion object {
        const val VALIDATION_SUCCESSFUL = "VALIDATION_SUCCESSFUL"
        const val ADDING_SUCCESSFUL = "Dodano godziny pomyślnie"
    }

    fun resolveForm(work: Work):String {
        var textToShow = validate(work)
        if (textToShow == VALIDATION_SUCCESSFUL) {
            val result = sendWorkToDatabase(work)
            textToShow = if (result) {
                ADDING_SUCCESSFUL
            } else {
                "Coś poszło nie tak! Sprawdź połączenie z internetem lub spróbuj ponownie później."
            }
        }

        return textToShow
    }

    private fun sendWorkToDatabase(work: Work): Boolean {

        val dbSendWork = DbSendWork(
            work.workName, work.workDescription, GlobalVars.firstName,
            GlobalVars.lastName, work.minutes.toInt(), work.hours.toInt()
        )
        dbSendWork.start()
        return dbSendWork.result
    }

    fun validate(work: Work): String {
        return when {
            work.workName.trim().isEmpty() or work.workDescription.trim().isEmpty() -> "Nazwa lub opis zadania jest pusty."
            !work.hours.isInt() or!work.minutes.isInt() -> "Czas musi być wyrażony w liczbach."
            work.minutes.toInt() > 60 -> "nie może być więcej niż 60min"
            else -> VALIDATION_SUCCESSFUL
        }
    }
}