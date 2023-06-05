package com.example.homework_1.db

import androidx.room.*
import com.example.homework_1.model.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<NoteEntity>

    @Query("SELECT * FROM note WHERE userEmail=(:userEmail)")
    suspend fun getNotesByEmail(userEmail: String): List<NoteEntity>
}