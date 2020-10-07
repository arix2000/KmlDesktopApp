package com.example

import com.example.stylesheets.StylesGlobal
import com.example.view.LoginView
import tornadofx.App

class MyApp: App(LoginView::class, StylesGlobal::class)