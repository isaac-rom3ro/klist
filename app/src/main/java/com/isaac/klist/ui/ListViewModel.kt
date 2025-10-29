package com.isaac.klist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.isaac.klist.data.DatabaseInstance
import kotlinx.coroutines.launch
import java.util.Date
import com.isaac.klist.data.ListEntity


class ListViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = DatabaseInstance.getDatabase(application).listDao()

    fun addList(name: String) {
        viewModelScope.launch {
            dao.insert(ListEntity(name = name, createdAt = Date(), updatedAt = Date()))
        }
    }

    fun getAllLists(callback: (List<ListEntity>) -> Unit) {
        viewModelScope.launch {
            val lists = dao.getAllLists()
            callback(lists)
        }
    }
}