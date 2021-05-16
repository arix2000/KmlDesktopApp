package com.example.controllers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WorksHistoryControllerTest {

    @Test
    fun getWorksHistory() {
        val controller = WorksHistoryController()
        print("---------> There is:" + controller.getWorksHistory())
    }
}