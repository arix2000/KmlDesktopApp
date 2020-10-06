package com.example

import com.example.AppColors.Companion.PRIMARY
import com.example.AppColors.Companion.PRIMARY_DARK
import com.example.AppColors.Companion.WHITE
import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.paint.Paint
import tornadofx.*
import java.net.URI

class Styles : Stylesheet() {

    private val MainRadius = multi(box(20.px))

    companion object {
        val captions by cssclass()
        val loginScreenMain by cssclass()
        val textFields by cssclass()
        val buttons by cssclass()
        val spacers by cssclass()
        val menuItems by cssclass()
        val listMenu by cssclass()
        val menuItemsSelected by cssclass()
    }

    init {
        loginScreenMain {
            prefHeight = 660.px
            prefWidth = 900.px
            alignment = Pos.CENTER
            spacing = 30.px
        }

        spacers {maxHeight = 40.px}

        buttons{
            backgroundColor = multi(PRIMARY_DARK)
            textFill = WHITE
            backgroundRadius = MainRadius
            padding = box(12.px,25.px)
        }

        textFields {
            padding = box(10.px)
            minWidth = 100.px
            maxWidth = 300.px
            textBoxBorder = PRIMARY
            focusColor = PRIMARY
            borderWidth = multi(box(2.px))
            backgroundRadius = MainRadius
            alignment = Pos.CENTER
        }

        captions {
            fontSize = 15.px
        }

        menuItems{
            prefWidth = 200.px
            backgroundColor = multi(PRIMARY)
            backgroundRadius = MainRadius
            padding = box(12.px)
            cursor = Cursor.DEFAULT
            textFill = WHITE
            and(hover){
                backgroundColor = multi(PRIMARY_DARK)
            }

        }

        menuItemsSelected {
            prefWidth = 200.px
            backgroundColor = multi(Paint.valueOf("#0700d8"))
            backgroundRadius = MainRadius
            padding = box(12.px)
            cursor = Cursor.DEFAULT
            textFill = WHITE
        }

        listMenu {
            spacing = 12.px
            backgroundColor = multi(PRIMARY)
            padding = box(8.px)
            labelPadding = box(8.px)
            textFill = PRIMARY

        }
    }
}

















