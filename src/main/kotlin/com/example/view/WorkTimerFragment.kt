package com.example.view

import javafx.scene.layout.VBox
import tornadofx.Fragment
import tornadofx.label
import tornadofx.paddingAll
import tornadofx.vbox

class WorkTimerFragment : Fragment() {


    override val root = vbox {
        paddingAll = 10.0
        label("Work timer Fragment")



    }
}