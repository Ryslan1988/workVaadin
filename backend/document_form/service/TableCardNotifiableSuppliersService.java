package ru.prominn.atombot.backend.document_form.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ru.prominn.atombot.backend.document_form.entity.TableCardNotifiableSuppliers;
import ru.prominn.atombot.backend.document_form.repository.TableCardNotifiableSuppliersRepository;

@Service
public class TableCardNotifiableSuppliersService {

    private static final Logger LOGGER = Logger.getLogger(TableCardNotifiableSuppliersService.class.getName());
    private TableCardNotifiableSuppliersRepository tableCardNotifiableSuppliersRepository;

    public TableCardNotifiableSuppliersService(TableCardNotifiableSuppliersRepository positionRepository) {
        this.tableCardNotifiableSuppliersRepository = positionRepository;
    }

    public TableCardNotifiableSuppliers findByID(String id) {
        return tableCardNotifiableSuppliersRepository.findByID(id);
    }

    public List<TableCardNotifiableSuppliers> findAll() {
        return tableCardNotifiableSuppliersRepository.findAll();
    }

    public List<TableCardNotifiableSuppliers> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return tableCardNotifiableSuppliersRepository.findAll();
        } else {
            return tableCardNotifiableSuppliersRepository.search(filterText);
        }
    }

    public long count() {
        return tableCardNotifiableSuppliersRepository.count();
    }

    public boolean delete(TableCardNotifiableSuppliers id) {
        try {
            tableCardNotifiableSuppliersRepository.delete(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public boolean arhive(TableCardNotifiableSuppliers id) {
        try {
            tableCardNotifiableSuppliersRepository.save(id);
            tableCardNotifiableSuppliersRepository.delete(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public void save(TableCardNotifiableSuppliers id) {
        if (id == null) {
            LOGGER.log(Level.SEVERE, "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        tableCardNotifiableSuppliersRepository.save(id);
    }

}
