package com.hisazakura.bankapplication.viewmodel

import androidx.lifecycle.*
import com.hisazakura.bankapplication.model.EntryData
import com.hisazakura.bankapplication.room.EntryDataDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EntryDataViewModel @Inject constructor(
    private val entryDataDatabase : EntryDataDatabase
) : ViewModel(){

    private val entryDataDao = entryDataDatabase.entryDataDao()

    fun getEntryDataById(id : Long) = entryDataDao.getEntryDataById(id).asLiveData()

    fun insertEntryData(entryData: EntryData): LiveData<EntryData> {
        return flow {
            viewModelScope.launch {
                val id = entryDataDao.insertEntryData(entryData)
                entryData.id = id
                emit(entryData)
            }
        }.flowOn(Dispatchers.IO).asLiveData()
    }

    fun getListUnit(): LiveData<List<EntryData>> {
        return entryDataDao.getAllEntryData().asLiveData()
    }

    fun deleteUnit(entryData: EntryData){
        viewModelScope.launch {
            entryDataDao.deleteEntryData(entryData)
        }
    }

}