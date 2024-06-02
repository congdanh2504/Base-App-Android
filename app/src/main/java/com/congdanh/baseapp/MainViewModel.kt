package com.congdanh.baseapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.congdanh.domain.model.Note
import com.congdanh.domain.usecase.GetNotesUseCase
import com.congdanh.domain.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNotes: GetNotesUseCase,
    private val insertNote: InsertNoteUseCase,
) : ViewModel() {

    init {
        viewModelScope.launch {
            getNotes().collect {
                Log.d("MainViewModel", "Notes: $it")
            }
        }
    }

    fun insertNote() {
        viewModelScope.launch {
            insertNote(Note(
                title = "Title",
                description = "Content",
                timestamp = System.currentTimeMillis()
            ))
        }
    }
}
