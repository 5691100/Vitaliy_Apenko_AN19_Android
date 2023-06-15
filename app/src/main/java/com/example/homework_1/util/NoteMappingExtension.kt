package com.example.homework_1.util

import com.example.homework_1.model.Note
import com.example.homework_1.model.entity.NoteEntity

fun Note.toNoteEntity(): NoteEntity =
    NoteEntity(
        id,
        userEmail,
        title,
        message,
        date
    )

fun NoteEntity.toNote(): Note =
    Note(
        id,
        userEmail,
        title,
        message,
        date
    )

fun List<NoteEntity>.toListNote(): ArrayList<Note> =
    (map {
        it.toNote()
    } as? ArrayList<Note>) ?: arrayListOf()