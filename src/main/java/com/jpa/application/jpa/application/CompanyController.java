package com.jpa.application.jpa.application;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyRepository repo;

    @GetMapping("/")
    public String welcome()
    {
        return "<html><body><h1>WELCOME</h1></body></html>";
    }

    // Get All Notes
    @GetMapping("/company")
    public List<Company> getAllNotes() {
        return repo.findAll();
    }

    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable(value = "id") int id) throws CompanyNotFoundException
    {
            Company company = repo.findById(id);
            if (company==null)
            {
                try{
                    throw new CompanyNotFoundException(id);
                }
                catch(CompanyNotFoundException e)
                {
                    System.out.println(e);
                }
            }
            return company;
    }

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) {
        return repo.save(company);
    }



}
