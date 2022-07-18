package com.pmhung2.crud_be.controller;

import com.pmhung2.crud_be.Model.Income;
import com.pmhung2.crud_be.Service.income.IIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/incomes")
public class IncomeController {
    @Autowired
    private IIncomeService incomeService;



    @GetMapping
    public ResponseEntity<Iterable<Income>> getAll() {
        List<Income> incomes = (List<Income>) incomeService.findAll();
        if (incomes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> findIncomeById(@PathVariable Long id) {
        Optional<Income> incomeOptional = incomeService.findById(id);
        if (!incomeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(incomeOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Income> saveIncome(@RequestBody Income income) {
        return new ResponseEntity<>(incomeService.save(income), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        Optional<Income> incomeOptional = incomeService.findById(id);
        if (!incomeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        income.setId(incomeOptional.get().getId());
        return new ResponseEntity<>(incomeService.save(income), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Income> deleteIncome(@PathVariable Long id) {
        Optional<Income> incomeOptional = incomeService.findById(id);
        if (!incomeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        incomeService.removeById(id);
        return new ResponseEntity<>(incomeOptional.get(), HttpStatus.NO_CONTENT);
    }
}
