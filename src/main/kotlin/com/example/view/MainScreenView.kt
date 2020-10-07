package com.example.view

import com.example.controllers.ProfileController
import com.example.stylesheets.StylesGlobal
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.layout.VBox
import tornadofx.*

class MainScreenView() : View("Panel użytkownika") {
    private val buttonList = listOf("profile", "addingWorkTime", "passwordChanging")
    lateinit var profileBtn: Button
    lateinit var addingWorkTimeBtn: Button
    lateinit var passwordChangingBtn: Button
    private var selectedButton: String = ""
        set(value) {
            selectChosen(value)
        }
    private val controller = ProfileController()
    lateinit var container: VBox


    override val root = hbox {

        vbox {
            addClass(StylesGlobal.listMenu)

            profileBtn = button("Profil") {
                addClass(StylesGlobal.menuItems)
                action { selectedButton = buttonList[0] }
                imageview(Image("profileIcon.png"))
            }
            addingWorkTimeBtn = button("Dodawanie godzin") {
                addClass(StylesGlobal.menuItems)
                action { selectedButton = buttonList[1] }
                imageview(Image("addWorkTime.png"))
            }

            passwordChangingBtn = button("Zmiana hasła") {
                addClass(StylesGlobal.menuItems)
                action { selectedButton = buttonList[2] }
                imageview(Image("changePassword.png"))
            }

        }

        container = vbox {


        }



        selectedButton = buttonList[0]

    }

    private fun selectChosen(button: String) {
        unMarkAll()
        when (button) {
            buttonList[0] -> {
                mark(profileBtn); container.replaceChildren(ProfileFragment())
            }
            buttonList[1] -> {
                mark(addingWorkTimeBtn); container.replaceChildren(WorkTimerFragment())
            }
            buttonList[2] -> {
                mark(passwordChangingBtn); container.replaceChildren(ManagePasswordFragment())
            }
        }
    }

    private fun mark(button: Button) {
        button.removeClass(StylesGlobal.menuItems)
        button.addClass(StylesGlobal.menuItemsSelected)
    }

    private fun unMarkAll() {
        unMark(profileBtn)
        unMark(addingWorkTimeBtn)
        unMark(passwordChangingBtn)
    }

    private fun unMark(button: Button) {
        button.removeClass(StylesGlobal.menuItemsSelected)
        button.addClass(StylesGlobal.menuItems)
    }

}
