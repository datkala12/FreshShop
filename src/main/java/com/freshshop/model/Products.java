package com.freshshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;


@Setter
@Getter
@Entity
public class Products extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int productId;
	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must be at least 3 characters long")
	private String productName;
	@NotBlank(message = "Description number must not be blank")
//	@Size(min = 10, message = "Description must be at least 3 characters long")
	private String description;

	@NotNull(message = "Price must not be null" )
	@Min(value = 0, message ="Price must be > 0" )
	private Long price;

	@NotNull(message = "Product image number must not be blank")
	private String product_img;

	@Transient
	private int quantity=1;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name="category_id", referencedColumnName = "category_id", nullable = true)
	private Categories categories;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Products products = (Products) o;
		return productId == products.productId && quantity == products.quantity && Objects.equals(productName, products.productName) && Objects.equals(description, products.description) && Objects.equals(price, products.price) && Objects.equals(product_img, products.product_img) && Objects.equals(categories, products.categories);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), productId, productName, description, price, product_img, quantity, categories);
	}
}
