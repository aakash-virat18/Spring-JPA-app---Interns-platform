package com.jpa.application.jpa.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Company getCompanyById(@PathVariable(value = "id") int id)
    {
            return repo.findById(id);
    }

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) {
        return repo.save(company);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(value = "id") int id) {
        repo.deleteById(id);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Company company, @PathVariable int id) {

        Optional<Company> companyRepo = Optional.ofNullable(repo.findById(id));

        if (!companyRepo.isPresent())
            return ResponseEntity.notFound().build();

        company.setId(id);

        repo.save(company);

        return ResponseEntity.noContent().build();
    }



}
