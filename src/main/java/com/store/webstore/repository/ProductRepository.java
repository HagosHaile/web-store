package com.store.webstore.repository;

import com.store.webstore.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  /**
   * Returns all products in the Products table
   */
  List<Product> findAll();

  /**
   * Looks for a product by id in the Products table
   * @return the product that matches the given id or Optional.empty
   */
  Optional<Product> findById(Long productId);

  /**
   * Looks for all the products that match the given category
   */
  List<Product> findByCategory(String productCategory);

  /**
   * Returns at most numberOfProducts from a database
   */
  default List<Product> findAtMostNumberOfProducts(int numberOfProducts) {
    Page<Product> page = findAll(PageRequest.of(0, numberOfProducts));
    return page.toList();
  }
}
