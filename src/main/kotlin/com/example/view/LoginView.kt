package com.example.view

import com.example.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.Text
import tornadofx.*

class LoginView : View("KmlDesktopApp - Logowanie") {

    lateinit var text: Text
    val login = SimpleStringProperty()
    val password = SimpleStringProperty()

    override val root = vbox {
        addClass(Styles.loginScreenMain)

        imageview("logo.png") {
            fitHeight = 150.0
            fitWidth = 200.0
            isPickOnBounds = true
            isPreserveRatio = true
        }


        textfield(login) {
            promptText = "Login"

            addClass(Styles.textFields)
        }

        passwordfield(password) {
            promptText = "Hasło"
            addClass(Styles.textFields)
        }


        button("Zaloguj") {
            addClass(Styles.buttons)
            action {
                replaceWith(MainScreenView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))

            }
        }

        text = text { addClass(Styles.captions) }


    }
}
