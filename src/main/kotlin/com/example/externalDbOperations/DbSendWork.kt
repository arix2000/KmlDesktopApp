package com.example.externalDbOperations

import com.example.GlobalVars
import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.io.UnsupportedEncodingException
import java.net.HttpURLConnection
import java.net.URLEncoder
import kotlin.math.roundToInt

class DbSendWork(var workName: String, var workDescription: String, var firstName: String,
                 var lastName: String, var minutes: Int, var hours: Int) : ExternalDbHelper() {

    private val fileName = "updateCzasPracy.php"
    var mResult = false

    override fun run() {
        mResult = false
        var timeToSend: Float = hours + minutes.toFloat() / 60
        timeToSend = roundToTwoDecimalPoint(timeToSend)
        val address = BASE_URL + fileName
        val httpConnection = setConnection(address)
        try {
            sendData(httpConnection, timeToSend)
            mResult = readResult(httpConnection!!) == "true"
        } catch (e: IOException) {
            println("run: " + e.message)
        }
    }

    private fun roundToTwoDecimalPoint(timeToSend: Float): Float {
        var timeToSend = timeToSend
        timeToSend *= 100
        timeToSend = timeToSend.roundToInt().toFloat()
        timeToSend /= 100
        return timeToSend
    }

    @Throws(IOException::class)
    private fun sendData(connection: HttpURLConnection?, timeToSend: Float) {
        val outStream = connection!!.outputStream
        val writer = BufferedWriter(OutputStreamWriter(outStream, "UTF-8"))
        val dataToSend = setDataToSend(timeToSend)
        writer.write(dataToSend)
        writer.flush()
        writer.close()
        outStream.close()
    }

    @Throws(UnsupportedEncodingException::class)
    private fun setDataToSend(timeToSend: Float): String {
        val workTimeExact = hours.toString() + "h " + minutes + "min"
        return (URLEncoder.encode("czasPracy", "UTF-8") + "=" + URLEncoder.encode(timeToSend.toString(), "UTF-8")
                + "&&" + URLEncoder.encode("loginId", "UTF-8") + "=" + URLEncoder.encode(
            GlobalVars.loginId.toString(),
            "UTF-8"
        )
                + "&&" + URLEncoder.encode("nazwaZadania", "UTF-8") + "=" + URLEncoder.encode(workName, "UTF-8")
                + "&&" + URLEncoder.encode("opisZadania", "UTF-8") + "=" + URLEncoder.encode(workDescription, "UTF-8")
                + "&&" + URLEncoder.encode("czasPracyDokladny", "UTF-8") + "=" + URLEncoder.encode(
            workTimeExact,
            "UTF-8"
        )
                + "&&" + URLEncoder.encode("imie", "UTF-8") + "=" + URLEncoder.encode(firstName, "UTF-8")
                + "&&" + URLEncoder.encode("nazwisko", "UTF-8") + "=" + URLEncoder.encode(lastName, "UTF-8"))
    }

    val result: Boolean
        get() {
            try {
                this.join()
            } catch (e: InterruptedException) {
                println("getResult: " + e.message)
            }
            return mResult
        }
}