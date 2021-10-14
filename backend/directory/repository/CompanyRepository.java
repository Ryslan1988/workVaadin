package ru.prominn.atombot.backend.directory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.prominn.atombot.backend.directory.entity.Company;



public interface CompanyRepository extends JpaRepository<Company, Long> {
	@Query("SELECT c FROM Company c " + 
			"WHERE lower(c.name) LIKE lower(concat('%', :searchTerm, '%')) " + 
			"OR lower(c.companyName) LIKE lower(concat('%', :searchTerm, '%'))")
	List<Company> search(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT h FROM Company h WHERE h.kuns = :id")
	Company findByID(@Param("id") String kuns);
	
	@Query("SELECT h FROM Company h WHERE h.name = :name")
	Company findByName(@Param("name") String name);
}
