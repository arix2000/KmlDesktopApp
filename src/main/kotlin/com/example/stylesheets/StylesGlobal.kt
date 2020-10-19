package com.example.stylesheets

import com.example.stylesheets.AppColors.Companion.ACCENT
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
        val profileMainLabels by cssclass()
        val profileLabels by cssclass()
        val profileGridPane by cssclass()
        val profileValues by cssclass()
        val profileIcons by cssclass()
        val profileSpacers by cssclass()
        val profileNestedLabels by cssclass()
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
            backgroundColor = multi(ACCENT)
            textFill = PRIMARY
            backgroundRadius = mainRadius
            padding = box(12.px, 25.px)
        }

        textFields {
            padding = box(10.px)
            minWidth = 100.px
            maxWidth = 300.px
            textFill = WHITE
            textBoxBorder = PRIMARY_DARK
            focusColor = PRIMARY_DARK
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
            backgroundColor = multi(PRIMARY_DARK)
            backgroundRadius = mainRadius
            padding = box(12.px)
            cursor = Cursor.DEFAULT
            fontWeight = FontWeight.BOLD
            textFill = PRIMARY
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
            textFill = PRIMARY
        }

        listMenu {
            spacing = 12.px
            backgroundColor = multi(PRIMARY_DARK)
            padding = box(8.px)
            labelPadding = box(8.px)
        }

        profileMainLabels {
            fontSize = 20.px
            textFill = WHITE
            fontWeight = FontWeight.BOLD
        }

        profileLabels {
            fontSize = 17.px
            prefWidth = 332.px
            alignment = Pos.CENTER
            textFill = WHITE
            padding = box(12.px)
            spacing = 12.px

        }

        profileIcons {
            minWidth = 50.px
            backgroundColor = multi(ACCENT)
            padding = box(10.px)
        }

        profileValues {
            fontSize = 17.px
            prefWidth = 332.px
            alignment = Pos.CENTER
            textFill = WHITE
            padding = box(12.px)
            spacing = 12.px
            fontWeight = FontWeight.BOLD
        }

        profileGridPane {
            prefWidth = 664.px
            prefColumnCount = 3
            padding = box(8.px)
            backgroundRadius = mainRadius
            backgroundColor = multi(PRIMARY_DARK)
        }

        profileSpacers {
            backgroundColor = multi(PRIMARY_DARK)
            backgroundRadius = mainRadius
            prefHeight = 1.px
        }

        profileNestedLabels {
            fontSize = 17.px
            prefWidth = 332.px
            alignment = Pos.CENTER_LEFT
            textFill = WHITE
            padding = box(12.px)
            spacing = 12.px
            fontWeight = FontWeight.BOLD
        }


    }
}

















