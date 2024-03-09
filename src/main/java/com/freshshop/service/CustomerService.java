package com.freshshop.service;

import com.freshshop.constant.FreshShopConstants;
import com.freshshop.model.Customer;
import com.freshshop.model.Roles;
import com.freshshop.repository.CustomerRepository;
import com.freshshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Customer customer) {
        boolean isSaved = false;
        Roles roles = roleRepository.getByRoleName(FreshShopConstants.USER_ROLE);
        customer.setRoles(roles);
        customer.setStatus(FreshShopConstants.OPEN);
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));

        customer = customerRepository.save(customer);
        if(customer != null && customer.getCustomerId() >=0){
            isSaved = true;
        }
        return isSaved;
    }


    public boolean updatePassword(Customer customer){
        boolean isUpdated = false;
        long currentTimeMillis = System.currentTimeMillis();
        int newPass = (int) (currentTimeMillis % 1000000);
        customer.setPwd(passwordEncoder.encode(String.valueOf(newPass)));
        customer = customerRepository.save(customer);
        customer.setConfirmPwd(String.valueOf(newPass));
        if(customer != null && customer.getCustomerId() >=0){
            isUpdated = true;
        }
        return isUpdated;
    }

    private static Pageable getPageable(int pageNumber, String sortField, String sortDir) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber -1, pageSize,sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        return pageable;
    }

    public Page<Customer> findAllCustomer(int pageNumber, String sortField, String sortDir){
        Pageable pageable = getPageable(pageNumber, sortField, sortDir);
        Page<Customer> customerPage = customerRepository.getAllCustomer(pageable);
        return customerPage;
    }

    public Page<Customer> findByCustomerName(int pageNumber, String sortField, String sortDir, String name){
        Pageable pageable = getPageable(pageNumber, sortField, sortDir);
        Page<Customer> customerPage = customerRepository.findByCustomerName(pageable, name);
        return customerPage;
    }


}
