package com.freshshop.repository;

import com.freshshop.model.OrderDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {
	@Query("select o from OrderDetails o")
	Page<OrderDetails> getAllOrderDetail(Pageable pageable);

	@Query("SELECT od FROM OrderDetails od INNER JOIN od.order o WHERE o.customer.customerId =?1 and o.orderId =?2")
	List<OrderDetails> findOrderDetailsByCustomerId(int customerId, int orderId);

	@Query("SELECT od FROM OrderDetails od WHERE od.order.orderId = ?1")
	List<OrderDetails> findOrderDetailsByOrderId(int orderId);
}
