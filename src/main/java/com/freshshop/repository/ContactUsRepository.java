package com.freshshop.repository;


import com.freshshop.model.ContactUs;
import com.freshshop.model.Report;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Integer> {
    @Query("select o from ContactUs o")
    Page<ContactUs> getAllMessage(Pageable pageable);

    @Query("select o from ContactUs o where o.status=?1")
    Page<ContactUs> getByStatus(String status, Pageable pageable);
    
    @Query("select o from ContactUs o where o.status=?1 and o.name=?2")
    Page<ContactUs> getByStatusAndName(String status, String name, Pageable pageable);

    @Transactional
    @Modifying //Use this to tell the Spring that this method will modify the table in DB (delete/update/...)
    @Query("Update ContactUs c set c.status = ?1 where c.contactId = ?2")
        //Query with the class
    int updateByStatus(String status, int contactId);

    @Query("SELECT new com.freshshop.model.Report(count(o)) " +
            "FROM ContactUs o " +
            "WHERE FUNCTION('MONTH', o.createdAt) = FUNCTION('MONTH', CURRENT_DATE)")
    Page<Report> getAllContactByCurrentMonth(Pageable pageable);

    @Query("SELECT new com.freshshop.model.Report(CONCAT(FUNCTION('YEAR', o.createdAt), '-', FUNCTION('MONTH', o.createdAt)), COUNT(o)) " +
            "FROM ContactUs o " +
            "GROUP BY CONCAT(FUNCTION('YEAR', o.createdAt), '-', FUNCTION('MONTH', o.createdAt)) " +
            "ORDER BY CONCAT(FUNCTION('YEAR', o.createdAt), '-', FUNCTION('MONTH', o.createdAt)) ASC")
    List<Report> getContactUsReports();


}

