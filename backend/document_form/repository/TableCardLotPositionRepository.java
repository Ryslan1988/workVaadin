package ru.prominn.atombot.backend.document_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.prominn.atombot.backend.document_form.entity.TableCardBasic;
import ru.prominn.atombot.backend.document_form.entity.TableCardLot;
import ru.prominn.atombot.backend.document_form.entity.TableCardLotPosition;
import ru.prominn.atombot.backend.document_form.entity.TableCardPosition;

import java.util.List;


public interface TableCardLotPositionRepository extends JpaRepository<TableCardLotPosition, Long> {
	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.id) LIKE lower(concat('%', :searchTerm, '%')) " +
			"OR lower(c.pred) LIKE lower(concat('%', :searchTerm, '%'))")
	List<TableCardLotPosition> search(@Param("searchTerm") String searchTerm);

	// FindByFilter All
	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.id) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search1(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.regNum) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search2(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.template) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search3(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.description) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search4(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.deleteFlag) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search5(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.parentDoc1) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search6(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.statusText) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search7(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.createdBy) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search8(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.createdDate) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search9(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.createdTime) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search10(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.changedBy) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search11(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.changedDate) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search12(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.changedTime) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search13(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.closedDate) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search14(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.closedTime) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search15(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.card_subtype) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search16(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.card_type) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search17(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.pred) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search18(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.kun) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search19(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.lifnr) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search20(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.depart) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search21(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.org_purch) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search22(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.resp_person) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search23(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.plan_year) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search24(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.proc_type) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search25(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.etp_kind) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search26(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.rcase_proc) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search27(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.waers) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search28(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.vat) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search29(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.am_with_nds) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search30(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.amount_nds) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search31(@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM TableCardLotPosition c " +
			"WHERE lower(c.am_not_nds) LIKE lower(concat('%', :searchTerm, '%')) ")
	List<TableCardLotPosition> search32(@Param("searchTerm") String searchTerm);

//End for MassFilter
	@Query("SELECT h FROM TableCardLotPosition h WHERE h.id = :id")
	TableCardLotPosition findByID(@Param("id") String id);


}