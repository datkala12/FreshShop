package com.freshshop.repository;

import com.freshshop.model.Customer;
import com.freshshop.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer readByEmail(String email);

    @Query("select o from Customer o")
    Page<Customer> getAllCustomer(Pageable pageable);

    @Query("select o from Customer o where o.customerName like ?1")
    Page<Customer> findByCustomerName(Pageable pageable,String customerName);

    @Query("select o.roles from Customer o where o.email like ?1")
    Customer findStatusByEmail(String email);

    @Query("SELECT new com.freshshop.model.Report(CONCAT(FUNCTION('YEAR', c.createdAt), '-', FUNCTION('MONTH', c.createdAt)), COUNT(c)) " +
            "FROM Customer c " +
            "GROUP BY CONCAT(FUNCTION('YEAR', c.createdAt), '-', FUNCTION('MONTH', c.createdAt)) " +
            "ORDER BY CONCAT(FUNCTION('YEAR', c.createdAt), '-', FUNCTION('MONTH', c.createdAt)) ASC")
    List<Report> getCustomerReports();

}
