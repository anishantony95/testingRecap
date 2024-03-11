package com.dealer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dealerTable")
public class DealerEntity {
	@Override
	public String toString() {
		return "DealerEntity [name=" + name + ", rating=" + rating + ", product=" + product + ", id=" + id + "]";
	}

	private String name;
	private int rating;
	private String product;
	@Id
//@GeneratedValue(Strategy=GeneratedValueIDENTITY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}
