package com.example.noteappyt.features.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteappyt.features.notes.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = true)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun noteDao():NoteDao
}