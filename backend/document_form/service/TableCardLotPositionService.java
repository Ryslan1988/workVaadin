package ru.prominn.atombot.backend.document_form.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.prominn.atombot.backend.document_form.entity.TableCardLot;
import ru.prominn.atombot.backend.document_form.entity.TableCardLotPosition;
import ru.prominn.atombot.backend.document_form.entity.TableCardPosition;
import ru.prominn.atombot.backend.document_form.repository.TableCardLotPositionRepository;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class TableCardLotPositionService {

    private static final Logger LOGGER = Logger.getLogger(TableCardLotPositionService.class.getName());
    private TableCardLotPositionRepository tableCardLotPositionRepository;

    public TableCardLotPositionService(TableCardLotPositionRepository tableCardLotPositionRepository) {

        this.tableCardLotPositionRepository = tableCardLotPositionRepository;
    }

    public TableCardLotPosition findByID(String id) {

        return tableCardLotPositionRepository.findByID(id);
    }

    //For the MassFilter
    public List<TableCardLotPosition> findAllFilter(String searchName, String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return tableCardLotPositionRepository.findAll();
        } else {
            if (searchName == "search2") {
                return tableCardLotPositionRepository.search2(filterText);
            }else if(searchName == "search1"){
                return tableCardLotPositionRepository.search1(filterText);
            } else if (searchName == "search3") {
                return tableCardLotPositionRepository.search3(filterText);
            } else if (searchName == "search4") {
                return tableCardLotPositionRepository.search4(filterText);
            } else if (searchName == "search5") {
                return tableCardLotPositionRepository.search5(filterText);
            } else if (searchName == "search6") {
                return tableCardLotPositionRepository.search6(filterText);
            } else if (searchName == "search7") {
                return tableCardLotPositionRepository.search7(filterText);
            } else if (searchName == "search8") {
                return tableCardLotPositionRepository.search8(filterText);
            } else if (searchName == "search9") {
                return tableCardLotPositionRepository.search9(filterText);
            } else if (searchName == "search10") {
                return tableCardLotPositionRepository.search10(filterText);
            } else if (searchName == "search11") {
                return tableCardLotPositionRepository.search11(filterText);
            } else if (searchName == "search12") {
                return tableCardLotPositionRepository.search12(filterText);
            } else if (searchName == "search13") {
                return tableCardLotPositionRepository.search13(filterText);
            } else if (searchName == "search14") {
                return tableCardLotPositionRepository.search14(filterText);
            } else if (searchName == "search15") {
                return tableCardLotPositionRepository.search15(filterText);
            } else if (searchName == "search16") {
                return tableCardLotPositionRepository.search16(filterText);
            } else if (searchName == "search17") {
                return tableCardLotPositionRepository.search17(filterText);
            } else if (searchName == "search18") {
                return tableCardLotPositionRepository.search18(filterText);
            } else if (searchName == "search19") {
                return tableCardLotPositionRepository.search19(filterText);
            } else if (searchName == "search20") {
                return tableCardLotPositionRepository.search20(filterText);
            } else if (searchName == "search21") {
                return tableCardLotPositionRepository.search21(filterText);
            } else if (searchName == "search22") {
                return tableCardLotPositionRepository.search22(filterText);
            } else if (searchName == "search23") {
                return tableCardLotPositionRepository.search23(filterText);
            } else if (searchName == "search24") {
                return tableCardLotPositionRepository.search24(filterText);
            } else if (searchName == "search25") {
                return tableCardLotPositionRepository.search25(filterText);
            } else if (searchName == "search26") {
                return tableCardLotPositionRepository.search26(filterText);
            } else if (searchName == "search27") {
                return tableCardLotPositionRepository.search27(filterText);
            } else if (searchName == "search28") {
                return tableCardLotPositionRepository.search28(filterText);
            } else if (searchName == "search29") {
                return tableCardLotPositionRepository.search29(filterText);
            } else if (searchName == "search30") {
                return tableCardLotPositionRepository.search30(filterText);
            } else if (searchName == "search31") {
                return tableCardLotPositionRepository.search31(filterText);
            } else if (searchName == "search32") {
                return tableCardLotPositionRepository.search32(filterText);
            }
            return tableCardLotPositionRepository.search(filterText);
        }
    }

    //End
    public List<TableCardLotPosition> findAll() {

        return tableCardLotPositionRepository.findAll();
    }

    public List<TableCardLotPosition> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return tableCardLotPositionRepository.findAll();
        } else {
            return tableCardLotPositionRepository.search(filterText);
        }
    }

    public long count() {
        return tableCardLotPositionRepository.count();
    }

    public boolean delete(TableCardLotPosition id) {
        try {
            tableCardLotPositionRepository.delete(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public void save(TableCardLotPosition id) {
        if (id == null) {
            LOGGER.log(Level.SEVERE,
                    "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        tableCardLotPositionRepository.save(id);
    }

}
