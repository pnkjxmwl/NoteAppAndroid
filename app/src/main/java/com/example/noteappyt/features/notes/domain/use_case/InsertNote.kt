package com.example.noteappyt.features.notes.domain.use_case

import com.example.noteappyt.features.notes.domain.NoteRepository
import com.example.noteappyt.features.notes.domain.model.Note
import javax.inject.Inject

class InsertNote @Inject constructor(
    private  val repository: NoteRepository
) {
    suspend operator fun invoke(note:Note)=
        repository.insertNote(note)
}