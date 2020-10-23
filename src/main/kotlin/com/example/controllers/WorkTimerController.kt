package com.example.controllers

import com.example.GlobalVars
import com.example.Work
import com.example.externalDbOperations.DbSendWork
import tornadofx.isInt
import java.lang.NumberFormatException

class WorkTimerController {

    companion object {
        const val VALIDATION_SUCCESSFUL = "VALIDATION_SUCCESSFUL"
    }

    fun resolveForm(work: Work):String {
        var textToShow = validate(work)
        if (textToShow == VALIDATION_SUCCESSFUL) {
            val result = sendWorkToDatabase(work)
            textToShow = if (result) {
                "Dodano godziny pomyślnie"
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

        return if (work.workName.trim().isEmpty() or work.workDescription.trim().isEmpty())
            "Nazwa lub opis zadania jest pusty."
        else if (!work.hours.isInt() or !work.minutes.isInt())
            "Czas musi być wyrażony w liczbach."
        else if (work.minutes.toInt() > 60)
            "nie może być więcej niż 60min"
        else
            VALIDATION_SUCCESSFUL

    }
}