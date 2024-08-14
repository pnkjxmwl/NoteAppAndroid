package com.example.noteappyt.features.notes.domain.use_case

data class UseCases(
    val insertNote: InsertNote,
    val updateNote: UpdateNote,
    val deleteNote: DeleteNote,
    val getNodeById: GetNodeById,
    val getAllNotes: GetAllNotes
)
