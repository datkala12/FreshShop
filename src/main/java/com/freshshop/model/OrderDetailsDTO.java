package com.freshshop.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class OrderDetailsDTO {
	private String productImage;
	private String productName;
	private Long price;
	private int quantity;
	private long amount;
	private LocalDateTime date;
	// constructor, getters, setters
}
