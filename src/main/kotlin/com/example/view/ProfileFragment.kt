package com.example.view

import com.example.app.Strings
import com.example.controllers.ProfileController
import com.example.stylesheets.StylesGlobal
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.text.FontWeight
import tornadofx.*

class ProfileFragment : Fragment() {

    private val controller = ProfileController()
    private var userInfo: List<String>

    init {
        userInfo = controller.getUserInfoFromDatabase()
        controller.setUserName(userInfo[0], userInfo[1])
    }


    override val root = vbox {
        paddingAll = 10.0
        alignment = Pos.TOP_CENTER
        spacing = 10.0
        anchorpaneConstraints { bottomAnchor = 0.0; leftAnchor = 0.0; rightAnchor = 0.0; topAnchor = 0.0 }

        hbox {
            spacing = 30.0
            alignment = Pos.TOP_CENTER
            imageview {
                alignment = Pos.TOP_LEFT
                fitHeight = 200.0
                fitWidth = 300.0
                isPreserveRatio = true
                isScaleShape = true
                setOnMouseClicked { image = controller.getImageFromDisk(currentWindow, image) }
                image = controller.decideAboutImage()
            }
            vbox {
                spacing = 30.0
                alignment = Pos.CENTER

                label(userInfo[0] + " " + userInfo[1]) {
                    addClass(StylesGlobal.profileMainLabels)
                }

                label(userInfo[5]) {
                    addClass(StylesGlobal.profileMainLabels)
                }
            }
        }

        gridpane {
            addClass(StylesGlobal.profileGridPane)

            row {

                imageview(Image(Strings.JOIN_YEAR)) {
                    addClass(StylesGlobal.profileIcons)
                }

                label("rok dołączenia:") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileLabels)
                }

                label(userInfo[2]) {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileValues)
                }
            }

            row {
                label("Czas pracy:") {
                    addClass(StylesGlobal.profileNestedLabels)
                    gridpaneConstraints { columnSpan = 2 }
                }
            }

            row {

                imageview(Image(Strings.WORK_TIME_SEASON)) {
                    addClass(StylesGlobal.profileIcons)
                }

                label("W tym sezonie:") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileLabels)
                }

                label(userInfo[3] + "h") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileValues)
                }
            }

            row {

                imageview(Image(Strings.WORK_TIME_MONTH)) {
                    addClass(StylesGlobal.profileIcons)
                }

                label("W tym miesiącu:") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileLabels)
                }

                label(userInfo[6] + "h") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileValues)
                }
            }

            row {
                label("Sekcje: ") {
                    addClass(StylesGlobal.profileNestedLabels)
                    gridpaneConstraints { columnSpan = 2 }
                }
            }

            row {
                label(controller.formatToShow(userInfo[4])) {
                    addClass(StylesGlobal.profileValues)
                    style { fontWeight = FontWeight.MEDIUM; wrapText = true }
                    gridpaneConstraints { columnSpan = 3; useMaxWidth = true }
                }
            }
        }
    }
}









