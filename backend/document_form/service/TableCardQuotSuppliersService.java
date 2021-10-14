package ru.prominn.atombot.backend.document_form.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.prominn.atombot.backend.document_form.entity.TableCardLot;
import ru.prominn.atombot.backend.document_form.entity.TableCardQuotSuppliers;
import ru.prominn.atombot.backend.document_form.repository.TableCardLotRepository;
import ru.prominn.atombot.backend.document_form.repository.TableCardQuotSuppliersRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class TableCardQuotSuppliersService {

    private static final Logger LOGGER = Logger.getLogger(TableCardQuotSuppliersService.class.getName());
    private TableCardQuotSuppliersRepository tableCardQuotSuppliersRepository;

    public TableCardQuotSuppliersService(TableCardQuotSuppliersRepository tableCardQuotSuppliersRepository) {

        this.tableCardQuotSuppliersRepository = tableCardQuotSuppliersRepository;
    }

    public TableCardQuotSuppliers findByID(String id) {

        return tableCardQuotSuppliersRepository.findByID(id);
    }

    public List<TableCardQuotSuppliers> findAll() {

        return tableCardQuotSuppliersRepository.findAll();
    }

    public List<TableCardQuotSuppliers> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return tableCardQuotSuppliersRepository.findAll();
        } else {
            return tableCardQuotSuppliersRepository.search(filterText);
        }
    }
    
    public long count() {
        return tableCardQuotSuppliersRepository.count();
    }

    public boolean delete(TableCardQuotSuppliers id) {
        try {
            tableCardQuotSuppliersRepository.delete(id);
        	return true;
        } catch (DataIntegrityViolationException e) {
        	return false;
        }
    }

    public void save(TableCardQuotSuppliers id) {
        if (id == null) {
            LOGGER.log(Level.SEVERE,
                "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        tableCardQuotSuppliersRepository.save(id);
    } 
    
}
