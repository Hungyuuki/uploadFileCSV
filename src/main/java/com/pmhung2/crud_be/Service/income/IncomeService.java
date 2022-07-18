package com.pmhung2.crud_be.Service.income;



import com.pmhung2.crud_be.Model.Income;
import com.pmhung2.crud_be.Repository.IIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncomeService implements IIncomeService {
    @Autowired
    private IIncomeRepository incomeRepository;


    @Override
    public Iterable<Income> findAll() {
        return incomeRepository.findAll();
    }

    @Override
    public Optional<Income> findById(Long id) {
        return incomeRepository.findById(id);
    }

    @Override
    public Income save(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public void removeById(Long id) {
        incomeRepository.deleteById(id);
    }
}
