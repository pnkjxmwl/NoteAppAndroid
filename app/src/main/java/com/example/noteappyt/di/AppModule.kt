package com.example.noteappyt.di

import android.content.Context
import androidx.room.Room
import com.example.noteappyt.features.notes.data.LocalDatabase
import com.example.noteappyt.features.notes.data.NoteRepositoryImpl
import com.example.noteappyt.features.notes.domain.NoteRepository
import com.example.noteappyt.features.notes.domain.use_case.DeleteNote
import com.example.noteappyt.features.notes.domain.use_case.GetAllNotes
import com.example.noteappyt.features.notes.domain.use_case.GetNodeById
import com.example.noteappyt.features.notes.domain.use_case.InsertNote
import com.example.noteappyt.features.notes.domain.use_case.UpdateNote
import com.example.noteappyt.features.notes.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context:Context) : LocalDatabase=
        Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            "local_database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideNoteRepository(db:LocalDatabase):NoteRepository{
        return NoteRepositoryImpl(dao = db.noteDao())
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: NoteRepository):UseCases{
        return UseCases(
            insertNote=InsertNote(repository),
            updateNote = UpdateNote(repository),
            deleteNote = DeleteNote(repository),
            getAllNotes = GetAllNotes(repository),
            getNodeById = GetNodeById(repository)
        )
    }

}