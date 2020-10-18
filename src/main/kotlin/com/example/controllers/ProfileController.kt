package com.example.controllers;

import com.example.GlobalVars
import javafx.scene.image.Image
import javafx.stage.FileChooser
import javafx.stage.Window
import java.io.File
import java.io.FileInputStream

class ProfileController {

    fun getImageFromDisk(window: Window?, image: Image): Image? {

        val file = FileChooser().showOpenDialog(window)

        return if (file != null) {
            savePath(file)
            Image(FileInputStream(file))
        } else image

    }

    private fun savePath(file: File) {
        val profilePhoto = File("profilePhoto.png")
        profilePhoto.writeBytes(file.readBytes())
    }

    fun decideAboutImage(): Image? =
        if (File(GlobalVars.PHOTO_FILE_NAME).exists()) {
            Image(FileInputStream(GlobalVars.PHOTO_FILE_NAME))
        } else
            Image("logo.png")

    fun logIn(login: String, password: String): Boolean {
        TODO("log in")
    }

    fun getUserInfoFromDatabase(): List<String> {
        TODO("DbGetUserData")
    }


}
