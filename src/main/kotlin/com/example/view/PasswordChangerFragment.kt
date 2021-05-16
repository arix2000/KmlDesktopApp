package com.example.view

import com.example.controllers.PasswordChangerController
import com.example.stylesheets.StylesGlobal
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import tornadofx.*
import kotlin.concurrent.thread

class PasswordChangerFragment : Fragment() {

    private var newPassword = PasswordField()
    private var oldPassword = PasswordField()
    private var resultText = Text()
    private val controller = PasswordChangerController()
    override val root = vbox {
        style {
            padding = box(10.px)
            alignment = Pos.CENTER
            prefHeight = 660.px
            prefWidth = 684.px
        }

        anchorpaneConstraints { bottomAnchor = 0.0; leftAnchor = 0.0; rightAnchor = 0.0; topAnchor = 0.0 }

        label("Zmień hasło:") { addClass(StylesGlobal.profileMainLabels) }

        spacer { addClass(StylesGlobal.spacers60) }

        text("stare hasło:") { addClass(StylesGlobal.captions) }
        oldPassword = passwordfield { addClass(StylesGlobal.textFields) }

        spacer { addClass(StylesGlobal.workTimerSpacers20) }

        text("nowe hasło:") { addClass(StylesGlobal.captions) }
        newPassword = passwordfield { addClass(StylesGlobal.textFields) }

        spacer { addClass(StylesGlobal.workTimerSpacers20) }

        button("zmień hasło") {
            addClass(StylesGlobal.buttons)
            action {
                resultText.text = if (controller.isSuite(newPassword.text, oldPassword.text)) {
                    controller.sendFormForResult(newPassword.text, oldPassword.text)
                } else {
                    "Zostały puste pola!"
                }
                oldPassword.text = ""
                newPassword.text = ""
                thread { Thread.sleep(4000); resultText.text = "" }
            }
        }

        spacer { addClass(StylesGlobal.workTimerSpacers20) }

        resultText = text { addClass(StylesGlobal.captions); textAlignment = TextAlignment.CENTER }
    }
}
