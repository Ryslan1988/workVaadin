package ru.prominn.atombot.backend.directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.prominn.atombot.backend.directory.entity.Contact;

import java.util.Collection;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {	
	@Query("select c from Contact c " + 
			"where lower(c.login) like lower(concat('%', :searchTerm, '%')) " + 
			"or lower(c.fullName) like lower(concat('%', :searchTerm, '%'))")
	List<Contact> search(@Param("searchTerm") String searchTerm);

	@Query("SELECT h FROM Contact h WHERE h.login = :id")
	Contact findByUsername(@Param("id") String login);
	
	@Query(value = "SELECT entry_id FROM repository_entry WHERE author = :id", nativeQuery = true)
	Collection<String> findAllContactFiles(@Param("id") String login);
}
