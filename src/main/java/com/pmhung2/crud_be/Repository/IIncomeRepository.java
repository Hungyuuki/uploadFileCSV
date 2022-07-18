package com.pmhung2.crud_be.Repository;


import com.pmhung2.crud_be.Model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncomeRepository extends JpaRepository<Income, Long> {
//    Iterable<Income> findByNameContainingBy(String name);


    @Query(value = "select * from" + "incomes where (income between ?1 and ?2)", nativeQuery = true)
    Iterable<Income> findIncomeBetween(Double min, Double max);
}
