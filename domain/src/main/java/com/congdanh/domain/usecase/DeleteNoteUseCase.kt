package com.congdanh.domain.usecase

import com.congdanh.domain.model.Note
import com.congdanh.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository,
) {
    suspend operator fun invoke(note: Note) {
        noteRepository.delete(note)
    }
}
