package ru.prominn.atombot.backend.directory.service;



import org.springframework.stereotype.Service;

import ru.prominn.atombot.backend.directory.entity.Contact;
import ru.prominn.atombot.backend.directory.repository.ContactRepository;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ContactService {
	
    private static final Logger LOGGER = Logger.getLogger(ContactService.class.getName());
    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact findByUsername(String login) {
        return contactRepository.findByUsername(login);
    }
    
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public List<Contact> findAll(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return contactRepository.findAll();
        } else  {
            return contactRepository.search(filterText);
        }
    }

    public long count() {
        return contactRepository.count();
    }
    
    public Collection<String> findAllContactFiles(String login) {
    	return contactRepository.findAllContactFiles(login);
    }

    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    public void save(Contact contact) {
        if (contact == null) {
            LOGGER.log(Level.SEVERE,
                "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        contactRepository.save(contact);
    }
    
}
