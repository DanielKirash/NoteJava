package com.Nota.ITS.Repository;

import com.Nota.ITS.entity.Nota;
import com.Nota.ITS.noteEnum.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Nota, Integer> {

    Nota findByIdNotaAndStatus(Integer IdNota, Status status);
    List<Nota> findAllByIdNotaAndStatus(Integer idNota, Status status);

    List<Nota> findAllByIdNota(Integer idNota);

    boolean existsByIdNota(int idNota);

    List<Nota> findAllByStatus(Status status);
}
