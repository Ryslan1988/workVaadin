package ru.prominn.atombot.backend.document_form.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ru.prominn.atombot.backend.document_form.entity.TableCardPosition;
import ru.prominn.atombot.backend.document_form.repository.TableCardPositionRepository;


@Service
public class TableCardPositionService {

    private static final Logger LOGGER = Logger.getLogger(TableCardPositionService.class.getName());
    private TableCardPositionRepository tableCardPositionRepository;

    public TableCardPositionService(TableCardPositionRepository tableCardLotPositionRepository) {
        this.tableCardPositionRepository = tableCardLotPositionRepository;
    }

    public TableCardPosition findByID(String id) {
        return tableCardPositionRepository.findByID(id);
    }

    public List<TableCardPosition> findAll() {
        return tableCardPositionRepository.findAll();
    }

    public List<TableCardPosition> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return tableCardPositionRepository.findAll();
        } else {
            return tableCardPositionRepository.search(filterText);
        }
    }
    public List<TableCardPosition> findAllP() {
        return tableCardPositionRepository.findAll();
    }

    public List<TableCardPosition> findAllP(String tCardPosition_id) {
        if (tCardPosition_id == null || tCardPosition_id.isEmpty()) {
            return tableCardPositionRepository.findAll();
        } else {
            return tableCardPositionRepository.search1(tCardPosition_id);
        }
    }

    public long count() {
        return tableCardPositionRepository.count();
    }

    public boolean delete(TableCardPosition id) {
        try {
            tableCardPositionRepository.delete(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public boolean arhive(TableCardPosition id) {
        try {
            tableCardPositionRepository.save(id);
            tableCardPositionRepository.delete(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public void save(TableCardPosition id) {
        if (id == null) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        tableCardPositionRepository.save(id);
    }

}
