package com.example.view

import com.example.controllers.WorkTimerController
import com.example.models.Work
import com.example.stylesheets.AppColors
import com.example.stylesheets.AppColors.Companion.BLACK
import com.example.stylesheets.AppColors.Companion.TEXT_FIELD_FILL
import com.example.stylesheets.AppColors.Companion.WHITE
import com.example.stylesheets.StylesGlobal
import com.sun.javafx.scene.control.DatePickerContent
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.control.skin.DatePickerSkin
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import javafx.util.StringConverter
import jfxtras.styles.jmetro.JMetro
import jfxtras.styles.jmetro.Style
import tornadofx.*
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import javax.swing.event.ChangeEvent
import kotlin.concurrent.thread

class WorkTimerFragment : Fragment() {

    private var workName = TextField()
    private var workDescription = TextField()
    private var date = SimpleObjectProperty<LocalDate>()
    private var hours = TextField()
    private var minutes = TextField()
    private val controller = WorkTimerController()
    private lateinit var resultText: Text

    override val root = vbox {
        style {
            padding = box(10.px)
            alignment = Pos.CENTER
            prefHeight = 660.px
            prefWidth = 684.px
        }



        anchorpaneConstraints { bottomAnchor = 0.0; leftAnchor = 0.0; rightAnchor = 0.0; topAnchor = 0.0 }

        label("Dodaj nowe zadanie:") { addClass(StylesGlobal.profileMainLabels) }

        spacer { addClass(StylesGlobal.spacers60) }

        text("Tytuł nowego zadania:") { addClass(StylesGlobal.captions) }
        workName = textfield() { addClass(StylesGlobal.textFields) }

        spacer { addClass(StylesGlobal.workTimerSpacers20) }

        text("Opis:") { addClass(StylesGlobal.captions) }
        workDescription = textfield { addClass(StylesGlobal.textFields) }

        spacer { addClass(StylesGlobal.workTimerSpacers20) }

        datepicker(date) {
            val metro = JMetro(Style.DARK)
            metro.parent = this

            value = LocalDate.now()
            converter = createOwnConverter()
            editor.addClass(StylesGlobal.workDateEditor)
            editor.style {
                backgroundColor = multi(TEXT_FIELD_FILL)
                textFill = AppColors.PRIMARY
            }

            style {
                backgroundColor = multi(TEXT_FIELD_FILL)
            }

        }

        spacer { addClass(StylesGlobal.workTimerSpacers20) }

        hbox {
            alignment = Pos.CENTER

            hours = textfield { addClass(StylesGlobal.textFields); prefWidth = 70.0 }
            text("  godzin   ") { addClass(StylesGlobal.captions) }

            minutes = textfield { addClass(StylesGlobal.textFields); prefWidth = 70.0 }
            text("  minut") { addClass(StylesGlobal.captions) }
        }

        spacer { addClass(StylesGlobal.workTimerSpacers20) }

        button("WYŚLIJ") {
            addClass(StylesGlobal.buttons)
            action {
                sendWork()
                thread { Thread.sleep(4000); resultText.text = "" }
                date.set(LocalDate.now())
            }
        }

        spacer { addClass(StylesGlobal.workTimerSpacers20) }

        resultText = text { addClass(StylesGlobal.captions); textAlignment = TextAlignment.CENTER }

    }

    private fun sendWork() {
        // 5.12.2020 format
        val description = "${format(date.get())} -> ${workDescription.text}"
        print("desc ----> $description")

        val work = Work(workName.text, description, hours.text, minutes.text)
        val textToShow = controller.resolveForm(work)
        resultText.text = textToShow

        if (textToShow == WorkTimerController.ADDING_SUCCESSFUL) {
            workName.clear(); workDescription.clear(); hours.clear(); minutes.clear()
        }
    }

    private fun createOwnConverter(): StringConverter<LocalDate> {
        return object : StringConverter<LocalDate>() {
            val dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            override fun toString(localDate: LocalDate): String {
                return dateTimeFormatter.format(localDate);
            }

            override fun fromString(string: String): LocalDate {
                return LocalDate.parse(string, dateTimeFormatter);
            }
        }
    }

    private fun format(date: LocalDate): String {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            .toString().replace("-", ".")
    }
}