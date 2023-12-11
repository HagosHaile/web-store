package com.store.webstore.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "ProductCategories")
public class ProductCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String category;

  public ProductCategory() {
  }

  public ProductCategory(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }
}
