package com.freshshop.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;


@Data
@Entity
public class Roles extends BaseEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private int roleId;

	private String roleName;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Roles roles = (Roles) o;
		return roleId == roles.roleId && Objects.equals(roleName, roles.roleName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), roleId, roleName);
	}
}
