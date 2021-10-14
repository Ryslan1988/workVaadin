package ru.prominn.atombot.backend.document_form.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.prominn.atombot.backend.document_form.entity.TableCardProcurementProcedure;
import ru.prominn.atombot.backend.document_form.repository.TableCardProcurementProcedureRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TableCardProcurementProcedureService {
    private static final Logger LOGGER = Logger.getLogger(TableCardLotService.class.getName());
    private TableCardProcurementProcedureRepository tableCardProcurementProcedureRepository;

    public TableCardProcurementProcedureService(TableCardProcurementProcedureRepository tableProcurementProcedureRepository) {

        this.tableCardProcurementProcedureRepository = tableProcurementProcedureRepository;
    }

    public TableCardProcurementProcedure findByID(String id) {

        return tableCardProcurementProcedureRepository.findByID(id);
    }

    public List<TableCardProcurementProcedure> findAll() {

        return tableCardProcurementProcedureRepository.findAll();
    }

    public List<TableCardProcurementProcedure> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return tableCardProcurementProcedureRepository.findAll();
        } else {
            return tableCardProcurementProcedureRepository.search(filterText);
        }
    }

    public long count() {
        return tableCardProcurementProcedureRepository.count();
    }

    public boolean delete(TableCardProcurementProcedure id) {
        try {
            tableCardProcurementProcedureRepository.delete(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public void save(TableCardProcurementProcedure id) {
        if (id == null) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        tableCardProcurementProcedureRepository.save(id);
    }
}
