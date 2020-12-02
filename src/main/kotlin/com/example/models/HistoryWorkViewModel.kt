package com.example.models

import tornadofx.ItemViewModel

class HistoryWorkViewModel: ItemViewModel<HistoryWork>() {

    val workName = bind(HistoryWork::workName)
    val workDescription = bind(HistoryWork::workDescription)
    val executionTime = bind(HistoryWork::executionTime)
    val date = bind(HistoryWork::date)

}