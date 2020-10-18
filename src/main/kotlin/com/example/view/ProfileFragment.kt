package com.example.view

import com.example.controllers.ProfileController
import com.example.stylesheets.AppColors.Companion.PRIMARY_DARK
import com.example.stylesheets.StylesGlobal
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.layout.*
import javafx.scene.paint.Paint
import tornadofx.*

class ProfileFragment : Fragment() {

    private val controller = ProfileController()

    override val root = vbox {
        paddingAll = 10.0
        alignment = Pos.CENTER
        spacing = 10.0

        hbox {
            spacing = 30.0
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

                label("Kazimiesz Kowalewski") {
                    addClass(StylesGlobal.profileMainLabels)
                }

                label("np. wolontariusz") {
                    addClass(StylesGlobal.profileMainLabels)
                }
            }
        }

        gridpane {
            addClass(StylesGlobal.profileGridPane)

            row {

                imageview(Image("joinYear.png")) {
                    addClass(StylesGlobal.profileIcons)
                }

                label("rok dołączenia:") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileLabels)
                }

                label("joinYear") {
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

                imageview(Image("workTimeSeason.png")) {
                    addClass(StylesGlobal.profileIcons)
                }

                label("W tym sezonie:") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileLabels)
                }

                label("workTimeSeason") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileValues)
                }
            }

            row {

                imageview(Image("workTimeMonth.png")) {
                    addClass(StylesGlobal.profileIcons)
                }

                label("W tym miesiącu:") {
                    gridpaneConstraints { fillWidth = true }
                    addClass(StylesGlobal.profileLabels)
                }

                label("workTimeMonth") {
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
        }


    }
}









