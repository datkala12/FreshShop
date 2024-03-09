package com.freshshop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.freshshop.model.Orders;
import com.freshshop.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	public boolean saveOrder(Orders order) {
		boolean isSaved = false;
		order = orderRepository.save(order);
		if (order.getOrderId() >= 0) {
			isSaved = true;
		}
		return isSaved;
	}

	private static Pageable getPageable(int pageNumber, String sortField, String sortDir) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(sortField).ascending());
		return pageable;
	}

	public Page<Orders> getAllOrder(String status, int pageNumber, String sortField, String sortDir, String fullName) {
		int pageSize = 10;
		if (status.equals("All")) {
			status = "";
		}
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(sortField).ascending());
		Page<Orders> pageOrder = orderRepository.findByCustomerNameAndDateAndStatus(fullName, status, pageable);
		return pageOrder;
	}

	public Page<Orders> findByCustomerName(int pageNumber, String sortField, String sortDir, String name) {
		Pageable pageable = getPageable(pageNumber, sortField, sortDir);
		Page<Orders> orrderPage = orderRepository.findByCustomerName(pageable, name);
		return orrderPage;
	}

	public void updateOrderStatus(String status, int orderId) {
		orderRepository.updateByStatus(status, orderId);
	}

	public void updateOrderStatus(int orderId, String newStatus) {
		Optional<Orders> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			Orders order = optionalOrder.get();
			order.setStatus(newStatus);
			orderRepository.save(order);
		}
	}

}
