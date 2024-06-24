package com.Nota.ITS.Controller;

import com.Nota.ITS.Service.NoteService;
import com.Nota.ITS.dto.NoteDto;
import com.Nota.ITS.entity.Nota;
import com.Nota.ITS.noteEnum.Status;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Note")
@RequiredArgsConstructor
public class Controller {

    private final NoteService noteService;

    @GetMapping
    public List<Nota> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("/search")
    public Nota getNotesByNoteId(@RequestParam Integer idNota){
        return noteService.getNotesByNoteId(idNota);
    }

    @GetMapping("/{idNota}")
    public List<Nota> getStorico(@PathVariable Integer idNota){
        return noteService.getStorico(idNota);
    }

    @PostMapping
    public NoteDto createNota(@RequestBody NoteDto noteDto){
        return noteService.createNota(noteDto);
    }

    @PutMapping("/{idNota}")
    public boolean modifyNota(@PathVariable Integer idNota, @RequestBody NoteDto noteDto){
        return noteService.modifyNota(idNota, noteDto);
    }

    @PutMapping("/delete/{idNota}")
    public boolean deleteNota(@PathVariable Integer idNota){
        return noteService.deleteNota(idNota);
    }
}



