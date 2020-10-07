package com.example.stylesheets

import com.example.stylesheets.AppColors.Companion.ACCENT
import com.example.stylesheets.AppColors.Companion.LIGHT_GRAY
import com.example.stylesheets.AppColors.Companion.PRIMARY
import com.example.stylesheets.AppColors.Companion.PRIMARY_DARK
import com.example.stylesheets.AppColors.Companion.TEXT_FIELD_FILL
import com.example.stylesheets.AppColors.Companion.WHITE
import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.paint.Paint
import javafx.scene.text.FontWeight
import tornadofx.*

class StylesGlobal : Stylesheet() {

    private val mainRadius = multi(box(20.px))

    companion object {
        val captions by cssclass()
        val primaryStage by cssclass()
        val textFields by cssclass()
        val buttons by cssclass()
        val spacers by cssclass()
        val menuItems by cssclass()
        val listMenu by cssclass()
        val menuItemsSelected by cssclass()
    }

    init {

        root {
            backgroundColor = multi(Paint.valueOf("#3c3f41"))
        }

        primaryStage {
            prefHeight = 660.px
            prefWidth = 900.px
            alignment = Pos.CENTER
            spacing = 30.px
        }

        spacers { maxHeight = 40.px }

        buttons {
            backgroundColor = multi(PRIMARY_DARK)
            textFill = LIGHT_GRAY
            backgroundRadius = mainRadius
            padding = box(12.px, 25.px)
        }

        textFields {
            padding = box(10.px)
            minWidth = 100.px
            maxWidth = 300.px
            textFill = WHITE
            textBoxBorder = PRIMARY
            focusColor = PRIMARY
            borderWidth = multi(box(2.px))
            backgroundColor = multi(TEXT_FIELD_FILL)
            backgroundRadius = mainRadius
            alignment = Pos.CENTER
        }

        captions {
            fontSize = 15.px
        }

        menuItems {
            prefWidth = 200.px
            backgroundColor = multi(PRIMARY)
            backgroundRadius = mainRadius
            padding = box(12.px)
            cursor = Cursor.DEFAULT
            fontWeight = FontWeight.BOLD
            textFill = LIGHT_GRAY
            and(hover) {
                textFill = WHITE
            }

        }

        menuItemsSelected {
            prefWidth = 200.px
            fontWeight = FontWeight.BOLD
            backgroundColor = multi(ACCENT)
            backgroundRadius = mainRadius
            padding = box(12.px)
            cursor = Cursor.DEFAULT
            textFill = LIGHT_GRAY

        }

        listMenu {
            spacing = 12.px
            backgroundColor = multi(PRIMARY)
            padding = box(8.px)
            labelPadding = box(8.px)

        }
    }
}

















