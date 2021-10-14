package ru.prominn.atombot.backend.document_form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.prominn.atombot.backend.document_form.entity.TableCardNotifiableSuppliers;



public interface TableCardNotifiableSuppliersRepository extends JpaRepository<TableCardNotifiableSuppliers, Long> {
	@Query("SELECT c FROM TableCardNotifiableSuppliers c " +
			"WHERE lower(c.id) LIKE lower(concat('%', :searchTerm, '%')) " +
			"OR lower(c.num) LIKE lower(concat('%', :searchTerm, '%'))")
	List<TableCardNotifiableSuppliers> search(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT h FROM TableCardNotifiableSuppliers h WHERE h.id = :id")
	TableCardNotifiableSuppliers findByID(@Param("id") String idPosition);
	
	@Query("SELECT h FROM TableCardNotifiableSuppliers h WHERE h.num = :num")
	TableCardNotifiableSuppliers findByName(@Param("num") String positionRegNumber);
}