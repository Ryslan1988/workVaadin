package ru.prominn.atombot.backend.directory.service;



import org.springframework.stereotype.Service;

import ru.prominn.atombot.backend.directory.entity.Company;
import ru.prominn.atombot.backend.directory.repository.CompanyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DataIntegrityViolationException;

@Service
public class CompanyService {

	private static final Logger LOGGER = Logger.getLogger(CompanyService.class.getName());
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findByID(String kuns) {
        return companyRepository.findByID(kuns);
    }
    
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    
    public List<Company> findAll(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return companyRepository.findAll();
        } else  {
            return companyRepository.search(filterText);
        }
    }
    
    public long count() {
        return companyRepository.count();
    }

    public boolean delete(Company company) {
        try {
        	companyRepository.delete(company);
        	return true;
        } catch (DataIntegrityViolationException e) {
        	return false;
        }
    }

    public void save(Company company) {
        if (company == null) {
            LOGGER.log(Level.SEVERE,
                "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        companyRepository.save(company);
    }
    
    public Map<String, Integer> getStats() {
        HashMap<String, Integer> stats = new HashMap<>();
        findAll().forEach(company ->
            stats.put(company.getName(), company.getEmployees().size()));
        return stats;
    }
}
