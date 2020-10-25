package com.example

import com.example.stylesheets.StylesGlobal
import com.example.view.LoginView
import tornadofx.*

class MyApp: App(LoginView::class, StylesGlobal::class)
{
    fun main(args: Array<String>)
    {
        launch<MyApp>(args)
    }
}