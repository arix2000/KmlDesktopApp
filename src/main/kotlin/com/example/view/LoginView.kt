package com.example.view

import com.example.app.GlobalVars
import com.example.app.Strings
import com.example.controllers.LoginController
import com.example.stylesheets.StylesGlobal
import javafx.event.EventType
import javafx.scene.control.PasswordField
import javafx.scene.control.ProgressIndicator
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.input.KeyCode
import javafx.scene.text.Text
import tornadofx.*

class LoginView : View("KmlDesktopApp - Logowanie") {

    lateinit var resultText: Text
    private var login = TextField()
    private var password = PasswordField()
    private val controller = LoginController()
    private var progressBar = ProgressIndicator()

    override val root = vbox {
        addClass(StylesGlobal.primaryStage)
        primaryStage.icons.add(Image(Strings.MAIN_ICON))

        setOnKeyPressed {
            if (it.code == KeyCode.ENTER)
                logIn()
        }

        imageview(Strings.LOGO) {
            fitHeight = 150.0
            fitWidth = 200.0
            isPickOnBounds = true
            isPreserveRatio = true
        }


        login = textfield {
            promptText = Strings.LOGIN

            addClass(StylesGlobal.textFields)
        }

        password = passwordfield {
            promptText = Strings.PASSWORD
            addClass(StylesGlobal.textFields)
        }


        button(Strings.LOG_IN) {
            addClass(StylesGlobal.buttons)

            action {
                logIn()
            }
        }

        resultText = text { addClass(StylesGlobal.captions) }

        progressBar = progressindicator { addClass(StylesGlobal.progressIndicator) }


        tryToReturnLogData()

    }

    private fun logIn() {
        progressBar.isVisible = true
        controller.setOnResultListener {
            if (it)
                replaceWith(
                    MainScreenView::class,
                    ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT)
                )
            else resultText.text = Strings.LOG_FAIL
            progressBar.isVisible = false
        }
        controller.logIn(login.text, password.text)
    }

    private fun tryToReturnLogData() {
        val logData = controller.getLogData()
        if (logData.contains(";")) {
            val logDataList = logData.split(";")
            login.text = logDataList[0]
            password.text = logDataList[1]
        }
    }
}
