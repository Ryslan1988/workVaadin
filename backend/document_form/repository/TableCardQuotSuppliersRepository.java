package ru.prominn.atombot.backend.document_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.prominn.atombot.backend.document_form.entity.TableCardLot;
import ru.prominn.atombot.backend.document_form.entity.TableCardQuotSuppliers;

import java.util.List;


public interface TableCardQuotSuppliersRepository extends JpaRepository<TableCardQuotSuppliers, Long> {
	@Query("SELECT c FROM TableCardQuotSuppliers c " +
			"WHERE lower(c.id) LIKE lower(concat('%', :searchTerm, '%')) " +
			"OR lower(c.pred) LIKE lower(concat('%', :searchTerm, '%'))")
	List<TableCardQuotSuppliers> search(@Param("searchTerm") String searchTerm);

	@Query("SELECT h FROM TableCardQuotSuppliers h WHERE h.id = :id")
	TableCardQuotSuppliers findByID(@Param("id") String id);

	@Query("SELECT h FROM TableCardQuotSuppliers h WHERE h.pred = :pred")
	TableCardQuotSuppliers findByName(@Param("pred") String pred);

}