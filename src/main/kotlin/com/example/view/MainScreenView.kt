package com.example.view

import com.example.Controller
import com.example.Styles
import javafx.scene.control.Button
import javafx.scene.image.Image
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
    private val controller = Controller()


    override val root = hbox {

        vbox {
            addClass(Styles.listMenu)

            profileBtn = button("Profil") {
                addClass(Styles.menuItems)
                action { selectedButton = buttonList[0] }
                imageview(Image("profileIcon.png"))
            }
            addingWorkTimeBtn = button("Dodawanie godzin") {
                addClass(Styles.menuItems)
                action { selectedButton = buttonList[1] }
                imageview(Image("addWorkTime.png"))


            }

            passwordChangingBtn = button("Zmiana hasła") {
                addClass(Styles.menuItems)
                action { selectedButton = buttonList[2] }
                imageview(Image("changePassword.png"))
            }

        }

        add(find<ProfileFragment>())

        selectedButton = buttonList[0]
    }

    private fun selectChosen(button: String) {
        unMarkAll()
        when (button) {
            buttonList[0] -> mark(profileBtn)
            buttonList[1] -> mark(addingWorkTimeBtn)
            buttonList[2] -> mark(passwordChangingBtn)
        }
    }

    private fun mark(button: Button) {
        button.removeClass(Styles.menuItems)
        button.addClass(Styles.menuItemsSelected)
    }

    private fun unMarkAll() {
        unMark(profileBtn)
        unMark(addingWorkTimeBtn)
        unMark(passwordChangingBtn)
    }

    private fun unMark(button: Button) {
        button.removeClass(Styles.menuItemsSelected)
        button.addClass(Styles.menuItems)
    }

}
