package com.store.webstore.repository;

import com.store.webstore.model.ProductCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {


  /**
   * Returns all the available categories of products in our online store
   */
  List<ProductCategory> findAll();
}
