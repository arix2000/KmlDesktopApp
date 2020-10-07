package com.example.view

import com.example.stylesheets.AppColors.Companion.WHITE
import com.example.controllers.ProfileController
import com.example.GlobalVars
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.text.FontWeight
import tornadofx.*
import java.io.File
import java.io.FileInputStream

class ProfileFragment : Fragment() {

    private val controller = ProfileController()

    override val root = vbox {
        paddingAll = 10.0


        hbox {
            spacing = 30.0
            imageview() {
                alignment = Pos.CENTER
                fitHeight = 200.0
                fitWidth = 300.0
                isPreserveRatio = true
                isScaleShape = true
                setOnMouseClicked { image = controller.getImageFromDisk(currentWindow, image) }
                image = decideAboutImage()
            }
            vbox {
                spacing = 30.0
                alignment = Pos.CENTER
                label("Kazimiesz Kowalewski").style {
                    textFill = WHITE
                    fontSize = 20.px
                    fontWeight = FontWeight.BOLD
                }
                label("np. wolontariusz").style {
                    textFill = WHITE
                    fontSize = 20.px
                    fontWeight = FontWeight.BOLD
                }

            }
        }


    }

    private fun decideAboutImage(): Image? {
        return if (File(GlobalVars.PHOTO_FILE_NAME).exists()) {
            Image(FileInputStream(GlobalVars.PHOTO_FILE_NAME))
        } else
            Image("logo.png")

    }
}