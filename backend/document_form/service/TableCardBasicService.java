package ru.prominn.atombot.backend.document_form.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.prominn.atombot.backend.document_form.entity.TableCardBasic;
import ru.prominn.atombot.backend.document_form.repository.TableCardBasicRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TableCardBasicService {
    private static final Logger LOGGER = Logger.getLogger(TableCardBasicService.class.getName());
    private TableCardBasicRepository tableCardBasicRepository;

    public TableCardBasicService(TableCardBasicRepository tableCardBasicRepository) {

        this.tableCardBasicRepository = tableCardBasicRepository;
    }

    public TableCardBasic findByID(String guid) {

        return tableCardBasicRepository.findByID(guid);
    }

    public List<TableCardBasic> findAll() {

        return tableCardBasicRepository.findAll();
    }

    public List<TableCardBasic> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return tableCardBasicRepository.findAll();
        } else {
            return tableCardBasicRepository.search(filterText);
        }
    }

    public long count() {

        return tableCardBasicRepository.count();
    }

    public boolean delete(TableCardBasic guid) {
        try {
            tableCardBasicRepository.delete(guid);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public void save(TableCardBasic guid) {
        if (guid == null ) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        tableCardBasicRepository.save(guid);

    }

}
