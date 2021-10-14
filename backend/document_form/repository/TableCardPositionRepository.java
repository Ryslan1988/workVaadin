package ru.prominn.atombot.backend.document_form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.prominn.atombot.backend.document_form.entity.TableCardPosition;



public interface TableCardPositionRepository extends JpaRepository<TableCardPosition, Long> {
	@Query("SELECT c FROM TableCardPosition c " +
			"WHERE lower(c.id) LIKE lower(concat('%', :searchTerm, '%')) " +
			"OR lower(c.lot_pos) LIKE lower(concat('%', :searchTerm, '%'))")
	List<TableCardPosition> search(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardPosition c " +
			"WHERE lower(c.tCardPosition_id) LIKE lower(concat('%', :searchTerm, '%')) " +
			"OR lower(c.tCardPosition_id) LIKE lower(concat('%', :searchTerm, '%'))")
	List<TableCardPosition> search1(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT h FROM TableCardPosition h WHERE h.id = :id")
	TableCardPosition findByID(@Param("id") String id);

//	"select ID " +
//			" from TableCardPosition "+
//			"left join TableCardLotPosition on "+
//			"TableCardLotPosition.id = tableCardLotPosition"

	@Query("SELECT e FROM TableCardPosition e INNER JOIN e.tCardPosition_id")
	TableCardPosition findByIDOneToMany(@Param("tCardPosition_id") String tCardPosition_id);
	
	@Query("SELECT h FROM TableCardPosition h WHERE h.guid = :guid")
    TableCardPosition findByName(@Param("guid") String guid);
}