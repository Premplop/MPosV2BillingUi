package com.example.dynamicviewmposv2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import `in`.co.logicsoft.lsutil.core.singleParam
import `in`.co.logicsoft.lsutil.core.unitParam
import `in`.co.logicsoft.lsutil.ui.dropdown.DropDownData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val selectedIndex: MutableLiveData<Int> = MutableLiveData()
    val selectItem: LiveData<Int> = selectedIndex
    val payModeSpinner: LiveData<DropDownData> = liveData {
        val payModes = listOf<String>("Google pay","Cash", "Paytm","Card")
        DropDownData(
            title = "Select Payment",
            entries = payModes,
            onEntrySelected = singleParam {
                selectedIndex.value = it
            }
        ).also {
            emit(it)
        }
    }


}