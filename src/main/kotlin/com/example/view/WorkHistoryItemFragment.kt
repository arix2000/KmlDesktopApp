package com.example.view

import com.example.models.WorkHistory
import com.example.models.WorkHistoryViewModel
import com.example.stylesheets.StylesGlobal
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.text.Text
import tornadofx.*

class WorkHistoryItemFragment : ListCellFragment<WorkHistory>() {

    private val work = WorkHistoryViewModel().bindTo(this)

    lateinit var date: Label
    lateinit var executionTime: Label
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

        executionTime = label(work.executionTime) {
            addClass(StylesGlobal.historyExecutionTime); alignment = Pos.BOTTOM_RIGHT
            anchorpaneConstraints { bottomAnchor = 0.0; leftAnchor = 0.0; rightAnchor = 0.0; topAnchor = 0.0 }
        }


    }
}