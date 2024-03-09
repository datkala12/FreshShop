package com.freshshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Setter
@Getter
public class Address extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int addressId;

	@NotBlank(message="Address1 must not be blank")
	@Size(min=5, message="Address1 must be at least 5 characters long")
	private String address1;

	private String address2;

//	@NotBlank(message="City must not be blank")
//	@Size(min=5, message="City must be at least 5 characters long")
//	private String city;
//
//	@NotBlank(message="State must not be blank")
//	@Size(min=5, message="State must be at least 5 characters long")
//	private String state;

	@NotBlank(message="Zip Code must not be blank")
	@Pattern(regexp="(^$|[0-9]{5})",message = "Zip Code must be 5 digits")
	private String zipCode;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Address address = (Address) o;
		return addressId == address.addressId && Objects.equals(address1, address.address1) && Objects.equals(address2, address.address2) && Objects.equals(zipCode, address.zipCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), addressId, address1, address2, zipCode);
	}
}
