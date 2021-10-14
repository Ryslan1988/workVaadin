package ru.prominn.atombot.backend.document_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.prominn.atombot.backend.document_form.entity.TableCardProcurementProcedure;

import java.util.List;

public interface TableCardProcurementProcedureRepository extends JpaRepository<TableCardProcurementProcedure, Long> {
    @Query("SELECT c FROM TableCardProcurementProcedure c " +
            "WHERE lower(c.id) LIKE lower(concat('%', :searchTerm, '%')) " +
            "OR lower(c.pred) LIKE lower(concat('%', :searchTerm, '%'))")
    List<TableCardProcurementProcedure> search(@Param("searchTerm") String searchTerm);

    @Query("SELECT h FROM TableCardProcurementProcedure h WHERE h.id = :id")
    TableCardProcurementProcedure findByID(@Param("id") String id);

    @Query("SELECT h FROM TableCardProcurementProcedure h WHERE h.pred = :pred")
    TableCardProcurementProcedure findByName(@Param("pred") String pred);

}