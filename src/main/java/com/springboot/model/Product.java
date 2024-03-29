package com.springboot.model;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

@Entity(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull( message="{NotNull.Product.name.validation}")
	@Size(min = 1, max = 30, message="{Size.Product.name.validation}")
	@Column(name = "name")
	private String name;
	
	@Size(min = 1, max = 300, message="{Size.Product.description.validation}")
	@Column(name = "description")
	private String description;
	
	@NotNull( message="{NotNull.Product.unitPrice.validation}")
	@Digits(integer = 4, fraction = 0, message="{Digits.Product.unitPrice.validation}")
	@Column(name = "unit_price")
	private BigDecimal  unitPrice;
	
	@Size(min = 3, max = 11, message="{Size.Product.condition.validation}")
	@Column(name = "condition_type")
	private String condition;
	
	@NotNull( message="{NotNull.Product.unitsInStock.validation}")
	@Digits(integer = 4, fraction = 0, message="{Digits.Product.unitsInStock.validation}")
	@Column(name = "units_in_stock")
	private long unitsInStock;
	
	@NotNull( message="{NotNull.Product.unitsInOrder.validation}")
	@Digits(integer = 4, fraction = 0, message="{Digits.Product.unitsInOrder.validation}")
	@Column(name = "units_in_order")
	private long unitsInOrder;
	
	@Column(name = "discontinued", columnDefinition = "BIT", length = 1)
	private Boolean discontinued;
	
	@Column(name = "disable", columnDefinition = "BIT", length = 1)
	private Boolean disable = false;

	@Column(name = "created", updatable = false)
	@CreationTimestamp
	private Date created;
	
	@Column(name = "updated")
	@UpdateTimestamp
	private Date updated;
	
	
	@Transient
	private MultipartFile productImage;
	
	@Transient
	private Set<String> listCategory;
	
	@Transient
	private Set<String> listPublish;

	
	
	public void setListCategory(Set<String> listCategory) {
		if(this.listCategory == null){
			this.listCategory = new HashSet<String>();
		}
		this.listCategory = listCategory;
	}
	
	public Set<String> getListCategory() {
		return listCategory;
	}

	public Set<String> getListPublish() {
		return listPublish;
	}

	public void setListPublish(Set<String> listPublish) {
		if(this.listPublish == null){
			this.listPublish = new HashSet<String>();
		}
		this.listPublish = listPublish;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unit_price) {
		this.unitPrice = unit_price;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

	
	
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

    @Override
    public String toString() {
        return "Product [condition=" + condition + ", created=" + created + ", description=" + description
                + ", disable=" + disable + ", discontinued=" + discontinued + ", id=" + id + ", listCategory="
                + listCategory + ", listPublish=" + listPublish + ", name=" + name + ", productImage=" + productImage
                + ", unitPrice=" + unitPrice + ", unitsInOrder=" + unitsInOrder + ", unitsInStock=" + unitsInStock
                + ", updated=" + updated + "]";
    }
	
	
	
}
