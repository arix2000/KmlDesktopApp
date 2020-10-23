package com.example.view

import com.example.Work
import com.example.controllers.WorkTimerController
import com.example.stylesheets.StylesGlobal
import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableStringValue
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import tornadofx.*
import kotlin.concurrent.thread

class WorkTimerFragment : Fragment() {

    private var workName = TextField()
    private var workDescription = TextField()
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


        text("Tytuł nowego zadania") { addClass(StylesGlobal.captions) }
        workName = textfield() { addClass(StylesGlobal.textFields) }

        spacer { addClass(StylesGlobal.workTimerSpacers) }

        text("Opis") { addClass(StylesGlobal.captions) }
        workDescription = textfield() { addClass(StylesGlobal.textFields) }

        spacer { addClass(StylesGlobal.workTimerSpacers) }

        hbox {
            alignment = Pos.CENTER

            hours = textfield() { addClass(StylesGlobal.textFields); prefWidth = 70.0 }
            text("  godzin   ") { addClass(StylesGlobal.captions) }

            minutes = textfield() { addClass(StylesGlobal.textFields); prefWidth = 70.0 }
            text("  minut") { addClass(StylesGlobal.captions) }
        }

        spacer { addClass(StylesGlobal.workTimerSpacers) }

        button("WYŚLIJ") {
            addClass(StylesGlobal.buttons)
            action {
                val work = Work(workName.text, workDescription.text, hours.text, minutes.text)

                val textToShow = controller.resolveForm(work)

                resultText.text = textToShow
                thread { Thread.sleep(4000); resultText.text = "" }
            }
        }

        spacer { addClass(StylesGlobal.workTimerSpacers) }

        resultText = text { addClass(StylesGlobal.captions); textAlignment = TextAlignment.CENTER }

    }
}