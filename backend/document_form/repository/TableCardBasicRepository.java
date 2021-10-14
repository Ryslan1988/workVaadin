package ru.prominn.atombot.backend.document_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.prominn.atombot.backend.document_form.entity.TableCardBasic;

import java.util.List;

public interface TableCardBasicRepository extends JpaRepository<TableCardBasic, Long> {
    @Query("SELECT c FROM TableCardBasic c " +
            "WHERE lower(c.guid) LIKE lower(concat('%', :searchTerm, '%')) " +
            "OR lower(c.regNum) LIKE lower(concat('%', :searchTerm, '%'))")
    List<TableCardBasic> search(@Param("searchTerm") String searchTerm);

    @Query("SELECT h FROM TableCardBasic h WHERE h.guid = :guid")
    TableCardBasic findByID(@Param("guid") String guid);

    @Query("SELECT h FROM TableCardBasic h WHERE h.regNum = :regNum")
    TableCardBasic findByName(@Param("regNum") String regNum);
}
