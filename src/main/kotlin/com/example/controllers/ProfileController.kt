package com.example.controllers;

import com.example.app.GlobalVars
import com.example.app.Strings
import com.example.externalDbOperations.DbGetUserData
import javafx.scene.image.Image
import javafx.stage.FileChooser
import javafx.stage.Window
import java.io.File
import java.io.FileInputStream

class ProfileController {

    fun getImageFromDisk(window: Window?, image: Image): Image {

        val file = FileChooser().showOpenDialog(window)

        return if (file != null) {
            savePath(file)
            Image(FileInputStream(file))
        } else image

    }

    private fun savePath(file: File) {
        val profilePhoto = File(Strings.PHOTO_FILE_NAME)
        profilePhoto.writeBytes(file.readBytes())
    }

    fun decideAboutImage(): Image =
        if (File(Strings.PHOTO_FILE_NAME).exists()) {
            Image(FileInputStream(Strings.PHOTO_FILE_NAME))
        } else {
            Image(Strings.PROFILE_PHOTO)
        }

    fun getUserInfoFromDatabase(): List<String> {
        val dbGetUserData = DbGetUserData()
        dbGetUserData.start()
        return dbGetUserData.result.split(";")
    }

    fun formatToShow(sections: String): String {

        var changedSection = sections.replace("-".toRegex(), ",")

        if (changedSection.contains("Wolontariusz") && changedSection.contains("Lider"))
            changedSection = "${changedSection.substring(0, changedSection.indexOf("Wolontariusz"))} \n\n" +
             changedSection.substring(changedSection.indexOf("Wolontariusz")).trimIndent()

        return changedSection
    }

    fun setUserName(firstName:String, lastName:String)
    {
        GlobalVars.firstName = firstName
        GlobalVars.lastName = lastName
    }


}
