package org.koreait.product.repositories;

import org.koreait.product.entities.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends ListCrudRepository<Product, Long> {
}
