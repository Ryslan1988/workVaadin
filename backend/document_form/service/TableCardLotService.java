package ru.prominn.atombot.backend.document_form.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ru.prominn.atombot.backend.document_form.entity.TableCardLot;
import ru.prominn.atombot.backend.document_form.repository.TableCardLotRepository;


@Service
public class TableCardLotService {

    private static final Logger LOGGER = Logger.getLogger(TableCardLotService.class.getName());
    private TableCardLotRepository tableCardLotRepository;

    public TableCardLotService(TableCardLotRepository tableCardLotRepository) {

        this.tableCardLotRepository = tableCardLotRepository;
    }

    public TableCardLot findByID(String id) {

        return tableCardLotRepository.findByID(id);
    }

    public List<TableCardLot> findAll() {

        return tableCardLotRepository.findAll();
    }

    public List<TableCardLot> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return tableCardLotRepository.findAll();
        } else {
            return tableCardLotRepository.search(filterText);
        }
    }
    
    public long count() {
        return tableCardLotRepository.count();
    }

    public boolean delete(TableCardLot id) {
        try {
        	tableCardLotRepository.delete(id);
        	return true;
        } catch (DataIntegrityViolationException e) {
        	return false;
        }
    }

    public void save(TableCardLot id) {
        if (id == null) {
            LOGGER.log(Level.SEVERE,
                "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        tableCardLotRepository.save(id);
    } 
    
}
