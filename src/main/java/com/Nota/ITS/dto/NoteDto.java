package com.Nota.ITS.dto;

import com.Nota.ITS.noteEnum.Status;
import lombok.Data;

@Data
public class NoteDto {

    private int idNota;
    private String noteName;
    private String noteContent;
    private Status status;
}
