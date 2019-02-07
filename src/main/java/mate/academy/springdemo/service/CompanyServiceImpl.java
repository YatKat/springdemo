package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Company;
import mate.academy.springdemo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getOne(id);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("CompanyServiceImpl is done");
        System.out.println("=============================================");
    }
}
