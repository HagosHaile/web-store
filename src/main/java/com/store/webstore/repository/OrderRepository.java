package com.store.webstore.repository;

import com.store.webstore.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  /**
   * Saves all orders in the Orders table
   *
   * @return the list of orders that were successfully saved
   */
  <S extends Order> List<S> saveAll(Iterable<S> orders);

  /**
   * Looks for an order in the DB that matches the first and last name of a user
   *
   * @return a list of orders for the given user
   */
  List<Order> findByFirstNameAndLastName(String firstName, String lastName);
}
