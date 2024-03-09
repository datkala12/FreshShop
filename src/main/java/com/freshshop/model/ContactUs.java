package com.freshshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name= "contact_msg")
public class ContactUs extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int contactId;

	@Size(min=3, message="Name must be at least 3 characters long")
	private String name;

	@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
	private String mobileNum;

	@Email(message = "Please provide a valid email address" )
	private String email;

	@Size(min=5, message="Subject must be at least 5 characters long")
	private String subject;

	@Size(min=10, message="Message must be at least 10 characters long")
	private String message;

	private String status;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		ContactUs contactUs = (ContactUs) o;
		return contactId == contactUs.contactId && Objects.equals(name, contactUs.name) && Objects.equals(mobileNum, contactUs.mobileNum) && Objects.equals(email, contactUs.email) && Objects.equals(subject, contactUs.subject) && Objects.equals(message, contactUs.message) && Objects.equals(status, contactUs.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), contactId, name, mobileNum, email, subject, message, status);
	}
}
