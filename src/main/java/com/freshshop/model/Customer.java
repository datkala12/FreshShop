package com.freshshop.model;

import com.freshshop.annotations.FieldsValueMatch;
import com.freshshop.annotations.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;


@Entity
@Setter
@Getter
//@FieldsValueMatch.List({
//        @FieldsValueMatch(
//                field="pwd",
//                fieldMatch="confirmPwd",
//                message="password do not match"
//        ),
//        @FieldsValueMatch(
//                field="email",
//                fieldMatch="confirmEmail",
//                message="email do not match"
//        )
//})
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int customerId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String customerName;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Confirm Email must not be blank")
    @Email(message = "Please provide a valid confirm email address")
    @Transient //Tell the Spring that don't save this field to the database
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    @PasswordValidator
    private String pwd;


    @NotBlank(message = "Password must not be blank")
    @Transient //Tell the Spring that don't save this field to the database
    private String confirmPwd;

    private String status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name="role_id", referencedColumnName = "roleId", nullable = true)
    private  Roles roles;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name="address_id", referencedColumnName = "addressId", nullable = true)
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Orders.class)
    private Set<Orders> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(customerName, customer.customerName) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(email, customer.email) && Objects.equals(confirmEmail, customer.confirmEmail) && Objects.equals(pwd, customer.pwd) && Objects.equals(confirmPwd, customer.confirmPwd) && Objects.equals(status, customer.status) && Objects.equals(roles, customer.roles) && Objects.equals(address, customer.address) && Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerId, customerName, phoneNumber, email, confirmEmail, pwd, confirmPwd, status, roles, address, orders);
    }
}
