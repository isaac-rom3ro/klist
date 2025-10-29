package com.isaac.klist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.isaac.klist.data.DatabaseInstance
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = DatabaseInstance.getDatabase(application).listDao()

    fun addList(name: String) {
        viewModelScope.launch {
            dao.insert(com.isaac.klist.data.ListEntity(name = name, createdAt = java.util.Date(), updatedAt = java.util.Date()))
        }
    }

    fun getAllLists(callback: (List<com.isaac.klist.data.ListEntity>) -> Unit) {
        viewModelScope.launch {
            val tasks = dao.getAllLists()
            callback(tasks)
        }
    }
}