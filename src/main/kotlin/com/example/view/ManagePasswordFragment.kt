package com.example.view

import tornadofx.Fragment
import tornadofx.label
import tornadofx.paddingAll
import tornadofx.vbox

class ManagePasswordFragment : Fragment() {

    override val root = vbox {
        paddingAll = 10.0
        label("Manage password Fragment")
    }
}