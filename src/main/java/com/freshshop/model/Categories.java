package com.freshshop.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categories extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="category_id")
    private int categoryId;

    private String categoryName;
    @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST, targetEntity = Products.class)
   private Set<Products> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Categories that = (Categories) o;
        return categoryId == that.categoryId && Objects.equals(categoryName, that.categoryName) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), categoryId, categoryName, products);
    }
}
