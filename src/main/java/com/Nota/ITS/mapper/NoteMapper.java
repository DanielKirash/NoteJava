package com.Nota.ITS.mapper;

import com.Nota.ITS.dto.NoteDto;
import com.Nota.ITS.entity.Nota;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NoteMapper {

    public static Nota noteRequestDtoToUtente(NoteDto noteRequestDto){
        Nota nota = new Nota();
        nota.setIdNota(noteRequestDto.getIdNota());
        nota.setNoteName(noteRequestDto.getNoteName());
        nota.setNoteContetn(noteRequestDto.getNoteConetnt());
        nota.setStatus(noteRequestDto.getStatus());
        return nota;
    }

    public static NoteDto noteToNote(Nota note){
        NoteDto noteResponseDto = new NoteDto();
        noteResponseDto.setNoteConetnt(note.getNoteContetn());
        noteResponseDto.setNoteName(note.getNoteName());
        noteResponseDto.setIdNota(note.getIdNota());
        noteResponseDto.setStatus(note.getStatus());
        return noteResponseDto;
    }

}
