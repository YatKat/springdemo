package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Company;

public interface CompanyService {
    Company createCompany(Company company);
    Company getCompanyById(Long id);
}
