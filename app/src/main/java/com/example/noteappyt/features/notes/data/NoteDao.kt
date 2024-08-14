package com.example.noteappyt.features.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteappyt.features.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun  insertNote(note: Note)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun updateNote(note:Note)

        @Delete
        suspend fun  deleteNote(note: Note)

        @Query("SELECT * FROM Note where id= :id")
        suspend fun getNoteById(id:Int) :Note

        @Query("SELECT * FROM Note ORDER BY id ASC")
        fun getAllNotes() : Flow<List<Note>>
}