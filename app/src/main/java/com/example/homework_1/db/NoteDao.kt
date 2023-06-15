package com.example.homework_1.db

import androidx.room.*
import com.example.homework_1.model.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM note WHERE id=(:id)")
    suspend fun getNoteWithId(id: Long): NoteEntity

    @Query("SELECT * FROM note WHERE userEmail=(:userEmail)")
    suspend fun getNotesByEmail(userEmail: String): List<NoteEntity>

    @Query("SELECT * FROM note WHERE userEmail=(:userEmail) and (title LIKE '%' || :search || '%' or message LIKE '%' || :search || '%')")
    suspend fun getSearchByEmail(userEmail: String, search: String): List<NoteEntity>
}