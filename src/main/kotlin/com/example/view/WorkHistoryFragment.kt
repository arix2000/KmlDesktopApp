package com.example.view

import com.example.controllers.WorksHistoryController
import com.example.models.WorkHistory
import com.example.stylesheets.AppColors.Companion.MAIN_BG
import com.example.stylesheets.StylesGlobal
import javafx.collections.ObservableList
import tornadofx.*

class WorkHistoryFragment : Fragment() {

    val controller = WorksHistoryController()

    var works:ObservableList<WorkHistory> = controller.getWorksHistory().asObservable()

    override val root = listview(works) {
        prefHeight = primaryStage.height

        style { borderColor = multi(box(MAIN_BG)); backgroundColor = multi(MAIN_BG) }
        anchorpaneConstraints { bottomAnchor = 0.0; leftAnchor = 0.0; rightAnchor = 0.0; topAnchor = 0.0 }
        cellFormat {
            addClass(StylesGlobal.historyCellFormat)
        }

        cellFragment(WorkHistoryItemFragment::class)
    }

}