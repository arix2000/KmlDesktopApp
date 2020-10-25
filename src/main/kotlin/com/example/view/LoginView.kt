package com.example.view

import com.example.controllers.LoginController
import com.example.stylesheets.StylesGlobal
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.text.Text
import tornadofx.*

class LoginView : View("KmlDesktopApp - Logowanie") {

    lateinit var resultText: Text
    private var login = TextField()
    private var password = PasswordField()
    private val controller = LoginController()

    override val root = vbox {
        addClass(StylesGlobal.primaryStage)

        imageview("/resources/logo.png") {
            fitHeight = 150.0
            fitWidth = 200.0
            isPickOnBounds = true
            isPreserveRatio = true
        }


        login = textfield() {
            promptText = "Login"

            addClass(StylesGlobal.textFields)
        }

        password = passwordfield() {
            promptText = "Hasło"
            addClass(StylesGlobal.textFields)
        }


        button("ZALOGUJ") {
            addClass(StylesGlobal.buttons)

            action {
                if(controller.logIn(login.text, password.text))
                replaceWith(MainScreenView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
                else resultText.text = "Nie prawidłowy login lub hasło lub brak połączenia z internetem!"
            }
        }

        resultText = text { addClass(StylesGlobal.captions) }


    }
}
