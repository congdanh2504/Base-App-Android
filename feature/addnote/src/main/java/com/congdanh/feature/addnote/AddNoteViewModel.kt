package com.congdanh.feature.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.congdanh.domain.model.Note
import com.congdanh.domain.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase
) : ViewModel() {

    fun addNote(note: Note) = viewModelScope.launch {
        insertNoteUseCase(note)
    }
}
