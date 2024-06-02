package com.congdanh.domain.usecase

import com.congdanh.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository,
) {
    operator fun invoke() = noteRepository.getNotes()
}
