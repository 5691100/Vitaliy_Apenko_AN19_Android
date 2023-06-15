package com.example.homework_1.db

import androidx.room.*
import com.example.homework_1.model.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM note")
    fun getAllNotes(): List<NoteEntity>
}