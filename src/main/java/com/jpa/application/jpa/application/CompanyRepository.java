package com.jpa.application.jpa.application;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company,Integer> {

    Company findById(int id);
    List<Company> findAll();
    List<Company> findByDuration(int duration);
    void deleteById(int id);
}
