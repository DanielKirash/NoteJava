package com.Nota.ITS.Service;

import com.Nota.ITS.Repository.NoteRepository;
import com.Nota.ITS.dto.NoteDto;
import com.Nota.ITS.entity.Nota;
import com.Nota.ITS.mapper.NoteMapper;
import com.Nota.ITS.noteEnum.Status;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.Nota.ITS.noteEnum.Status.*;


@Service
@RequiredArgsConstructor
@Builder
public class NoteService {

    private final NoteRepository noteRepository;

    //Trova solo gli Effettivi
    public List<Nota> getAllNotes(){
        return noteRepository.findAllByStatus(Effettivo);
    }

    //Trova solo la nota Effettiva richiesta
    public Nota getNotesByNoteId(Integer idNota){
        return noteRepository.findByIdNotaAndStatus(idNota, Effettivo);
    }

    //Crea la nota (Controlla se l'id è esistente)
    public NoteDto createNota(NoteDto noteDto){
        if(!noteRepository.existsByIdNota(noteDto.getIdNota()))
        {
        Nota noteDto1 = NoteMapper.noteRequestDtoToUtente(noteDto);
        noteDto1 = noteRepository.save(noteDto1);
        return NoteMapper.noteToNote(noteDto1);
        }else{
            return null;
        }
    }

    //Ritorna lo storico della nota eccetto l'effettivo
    public List<Nota> getStorico(Integer idNota){
        return noteRepository.findAllByIdNotaAndStatus(idNota, Modificato);
    }

    //Modifica la nota
    public boolean modifyNota(Integer idNota, NoteDto noteDto){
        Nota nota = noteRepository.findByIdNotaAndStatus(idNota, Effettivo);
        nota.setStatus(Modificato);
        Nota modifiedNota = NoteMapper.noteRequestDtoToUtente(noteDto);
        modifiedNota.setIdNota(idNota);
        modifiedNota.setStatus(Effettivo);
        modifiedNota = noteRepository.save(modifiedNota);
        return true;
    }

    //Elimina la nota e setta tutto su Eliminato!
    public boolean deleteNota(Integer idNota){
        List<Nota> nota = noteRepository.findAllByIdNota(idNota);
        for (Nota nota1 : nota) {
            nota1.setStatus(Eliminato);
            noteRepository.save(nota1);
        }
        return true;
    }

}
