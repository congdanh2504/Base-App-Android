package com.congdanh.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.congdanh.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getNotesUseCase: GetNotesUseCase,
) : ViewModel() {

    val notes = getNotesUseCase().stateIn(
        viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = emptyList()
    )
}
