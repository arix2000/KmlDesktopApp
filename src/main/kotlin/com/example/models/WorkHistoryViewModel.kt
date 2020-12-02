package com.example.models

import tornadofx.ItemViewModel

class WorkHistoryViewModel: ItemViewModel<WorkHistory>() {

    val workName = bind(WorkHistory::workName)
    val workDescription = bind(WorkHistory::workDescription)
    val executionTime = bind(WorkHistory::executionTime)
    val date = bind(WorkHistory::date)

}