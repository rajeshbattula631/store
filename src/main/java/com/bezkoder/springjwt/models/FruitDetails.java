package com.bezkoder.springjwt.models;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(	name = "fruit_details")
public class FruitDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private int boxCount;

	@NotNull
	private BigDecimal amount;
	
	@Column(name = "balance_amount", nullable = false)
	private BigDecimal balance_amount;
	
	@NotBlank
	@Size(max = 30)
	private String fruit_name;
	
	@NotBlank
	@Size(max = 30)
	private String customer_name;
	
	@NotBlank
	@Size(max = 10)
	private String customer_phoneNumber;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnoreProperties("fruit_details")
	private User user;
	
	
	public FruitDetails() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getBoxCount() {
		return boxCount;
	}


	public void setBoxCount(int boxCount) {
		this.boxCount = boxCount;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public BigDecimal getBalance_amount() {
		return balance_amount;
	}


	public void setBalance_amount(BigDecimal balance_amount) {
		this.balance_amount = balance_amount;
	}


	public String getFruit_name() {
		return fruit_name;
	}


	public void setFruit_name(String fruit_name) {
		this.fruit_name = fruit_name;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	public String getCustomer_phoneNumber() {
		return customer_phoneNumber;
	}


	public void setCustomer_phoneNumber(String customer_phoneNumber) {
		this.customer_phoneNumber = customer_phoneNumber;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, balance_amount, boxCount, customer_name, customer_phoneNumber, fruit_name, id,
				user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FruitDetails other = (FruitDetails) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(balance_amount, other.balance_amount)
				&& boxCount == other.boxCount && Objects.equals(customer_name, other.customer_name)
				&& Objects.equals(customer_phoneNumber, other.customer_phoneNumber)
				&& Objects.equals(fruit_name, other.fruit_name) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}


	@Override
	public String toString() {
		return "FruitDetails [id=" + id + ", boxCount=" + boxCount + ", amount=" + amount + ", balance_amount="
				+ balance_amount + ", fruit_name=" + fruit_name + ", customer_name=" + customer_name
				+ ", customer_phoneNumber=" + customer_phoneNumber + ", user=" + user + "]";
	}


	public FruitDetails(Long id, @NotBlank int boxCount, @NotBlank BigDecimal amount, @Null BigDecimal balance_amount,
			@NotBlank @Size(max = 30) String fruit_name, @NotBlank @Size(max = 30) String customer_name,
			@NotBlank @Size(max = 10) String customer_phoneNumber) {
		super();
		this.id = id;
		this.boxCount = boxCount;
		this.amount = amount;
		this.balance_amount = balance_amount;
		this.fruit_name = fruit_name;
		this.customer_name = customer_name;
		this.customer_phoneNumber = customer_phoneNumber;
	}


	
}
