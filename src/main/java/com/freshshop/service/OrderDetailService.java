package com.freshshop.service;

import com.freshshop.model.OrderDetails;
import com.freshshop.model.Orders;
import com.freshshop.repository.OrderDetailRepository;
import com.freshshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public boolean saveOrderDetail(OrderDetails orderDetails){
        boolean isSaved = false;

//        if(orderSave!=null && orderSave.getOrder_id()>0){
//            isSaved=true;
//        }
        return isSaved;
    }

    public Page<OrderDetails> getAllOrderDetail(int pageNumber, String sortField, String sortDir) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        Page<OrderDetails> pageOrder = orderDetailRepository.getAllOrderDetail(pageable);
        return pageOrder;
    }
}
