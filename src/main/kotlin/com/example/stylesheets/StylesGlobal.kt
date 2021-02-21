package com.example.stylesheets

import com.example.stylesheets.AppColors.Companion.ACCENT
import com.example.stylesheets.AppColors.Companion.MAIN_BG
import com.example.stylesheets.AppColors.Companion.PRIMARY
import com.example.stylesheets.AppColors.Companion.PRIMARY_DARK
import com.example.stylesheets.AppColors.Companion.TEXT_FIELD_FILL
import com.example.stylesheets.AppColors.Companion.WHITE
import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.control.OverrunStyle
import javafx.scene.paint.Paint
import javafx.scene.text.FontWeight
import tornadofx.*
import java.util.*
import kotlin.math.max

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
        val profileNestedLabels by cssclass()

        val workTimerSpacers20 by cssclass()
        val spacers60 by cssclass()
        val itemContainer by cssclass()

        val historyName by cssclass()
        val historyDescription by cssclass()
        val historyDate by cssclass()
        val historyExecutionTime by cssclass()
        val historyCellFormat by cssclass()

        val progressIndicator by cssclass()
        val mainProgressIndicator by cssclass()

        val workDateEditor by cssclass()
        val datePickerCell by cssclass()
        val datePickerCellOtherMonth by cssclass()
    }

    init {

        root {
            backgroundColor = multi(Paint.valueOf("#3c3f41"))
        }

        primaryStage {
            prefHeight = 660.px
            prefWidth = 1050.px
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
            fill = WHITE
        }

        menuItems {
            minWidth = 200.px
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
            alignment = Pos.TOP_CENTER
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

        profileNestedLabels {
            fontSize = 17.px
            prefWidth = 332.px
            alignment = Pos.CENTER_LEFT
            textFill = WHITE
            padding = box(12.px)
            spacing = 12.px
            fontWeight = FontWeight.BOLD
        }

        workTimerSpacers20 {
            maxHeight = 20.px
        }

        spacers60 {
            maxHeight = 60.px
        }

        itemContainer {
            backgroundColor = multi(PRIMARY_DARK)
            minWidth = 400.px
            wrapText = true
            backgroundRadius = mainRadius
            borderRadius = mainRadius
            padding = box(12.px)
        }

        historyName {
            maxWidth = 500.px
            textOverrun = OverrunStyle.ELLIPSIS
            wrapText = true
            fontSize = 17.px
            fontWeight = FontWeight.BOLD
            fill = Paint.valueOf("#3d5ce4")
        }

        historyDescription {
            prefWidth = 200.px
            maxWidth = 1500.px
            fitToHeight = true
            wrapText = true
            textFill = PRIMARY
        }

        historyDate {
            fontSize = 17.px
            textFill = PRIMARY
            fontWeight = FontWeight.BOLD
            maxWidth = 500.px
            textFill = PRIMARY
        }

        historyExecutionTime {
            fontSize = 13.px
            textFill = PRIMARY
            fontWeight = FontWeight.BOLD
            maxWidth = 500.px
            padding = box(30.px,0.px,0.px,0.px)
            textFill = PRIMARY
        }

        historyCellFormat {
            backgroundColor = multi(MAIN_BG)
            borderWidth = multi(box(0.px))
            borderRadius = multi(box(12.px))
        }

        progressIndicator {
            visibility = FXVisibility.HIDDEN
            prefHeight = 34.px
            prefWidth = 34.px
        }

        mainProgressIndicator {
            visibility = FXVisibility.HIDDEN
            prefHeight = 34.px
            prefWidth = 34.px
        }

        workDateEditor {
            backgroundColor = multi(TEXT_FIELD_FILL)
            textFill = PRIMARY
        }

        datePickerCell {
            backgroundColor = multi(MAIN_BG)
            textFill = PRIMARY
            borderColor = multi(box(PRIMARY_DARK))
        }

        datePickerCellOtherMonth {
            backgroundColor = multi(PRIMARY_DARK)
            textFill = PRIMARY
            borderColor = multi(box(PRIMARY_DARK))
        }
    }
}

















