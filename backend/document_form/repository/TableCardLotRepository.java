package ru.prominn.atombot.backend.document_form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.prominn.atombot.backend.document_form.entity.TableCardBasic;
import ru.prominn.atombot.backend.document_form.entity.TableCardLot;


public interface TableCardLotRepository extends JpaRepository<TableCardLot, Long> {
	@Query("SELECT c FROM TableCardLot c " +
			"WHERE lower(c.id) LIKE lower(concat('%', :searchTerm, '%')) " +
			"OR lower(c.pred) LIKE lower(concat('%', :searchTerm, '%'))")
	List<TableCardLot> search(@Param("searchTerm") String searchTerm);

	@Query("SELECT h FROM TableCardLot h WHERE h.id = :id")
	TableCardLot findByID(@Param("id") String id);

	@Query("SELECT h FROM TableCardLot h WHERE h.pred = :pred")
	TableCardLot findByName(@Param("pred") String pred);

}