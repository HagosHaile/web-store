package com.store.webstore.service;

import com.store.webstore.model.Product;
import com.store.webstore.repository.ProductCategoryRepository;
import com.store.webstore.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;

  public ProductsService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
    this.productRepository = productRepository;
    this.productCategoryRepository = productCategoryRepository;
  }

  public List<String> getAllSupportedCategories() {
    return productCategoryRepository.findAll()
        .stream()
        .map(productCategory -> productCategory.getCategory())
        .collect(Collectors.toList());
  }

  public List<Product> getDealsOfTheDay(int atMostNumberOfProducts) {
    return productRepository.findAtMostNumberOfProducts(atMostNumberOfProducts);
  }

  public List<Product> getProductsByCategory(String category) {
    return productRepository.findByCategory(category);
  }

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException(String.format("Product with id %s doesn't exist", id)));
  }
}
