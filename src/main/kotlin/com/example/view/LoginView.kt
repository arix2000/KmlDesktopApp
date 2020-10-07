package com.example.view

import com.example.stylesheets.StylesGlobal
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.Text
import tornadofx.*

class LoginView : View("KmlDesktopApp - Logowanie") {

    lateinit var text: Text
    val login = SimpleStringProperty()
    val password = SimpleStringProperty()

    override val root = vbox {
        addClass(StylesGlobal.primaryStage)

        imageview("logo.png") {
            fitHeight = 150.0
            fitWidth = 200.0
            isPickOnBounds = true
            isPreserveRatio = true
        }


        textfield(login) {
            promptText = "Login"

            addClass(StylesGlobal.textFields)
        }

        passwordfield(password) {
            promptText = "Hasło"
            addClass(StylesGlobal.textFields)
        }


        button("Zaloguj") {
            addClass(StylesGlobal.buttons)
            action {
                replaceWith(MainScreenView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))

            }
        }

        text = text { addClass(StylesGlobal.captions) }


    }
}
