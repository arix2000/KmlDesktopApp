package com.example.controllers;

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

    private fun savePath(file:File) {
        val profilePhoto = File("profilePhoto.png")
        profilePhoto.writeBytes(file.readBytes())
    }

}
