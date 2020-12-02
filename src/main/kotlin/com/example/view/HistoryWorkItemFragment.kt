package com.example.view

import com.example.models.HistoryWork
import com.example.models.HistoryWorkViewModel
import com.example.stylesheets.AppColors.Companion.PRIMARY_DARK
import com.example.stylesheets.StylesGlobal
import javafx.geometry.Pos
import javafx.scene.CacheHint
import javafx.scene.Parent
import javafx.scene.control.Label
import javafx.scene.control.Tooltip
import javafx.scene.paint.Paint
import javafx.scene.text.Text
import tornadofx.*

class HistoryWorkItemFragment : ListCellFragment<HistoryWork>() {

    private val work = HistoryWorkViewModel().bindTo(this)

    lateinit var date: Label
    lateinit var workName: Text
    lateinit var workDescription: Label

    override val root = anchorpane {
        addClass(StylesGlobal.itemContainer)
        vbox {
            anchorpaneConstraints { bottomAnchor = 0.0; leftAnchor = 0.0; rightAnchor = 0.0; topAnchor = 0.0 }
            alignment = Pos.TOP_LEFT

            workName = text(work.workName) {
                addClass(StylesGlobal.historyName)
                wrappingWidth = 600.0
            }

            workDescription = label(work.workDescription) {
                addClass(StylesGlobal.historyDescription)
            }

        }

        date = label(work.date) {
            addClass(StylesGlobal.historyDate); alignment = Pos.TOP_RIGHT
            anchorpaneConstraints { bottomAnchor = 0.0; leftAnchor = 0.0; rightAnchor = 0.0; topAnchor = 0.0 }
        }


    }
}