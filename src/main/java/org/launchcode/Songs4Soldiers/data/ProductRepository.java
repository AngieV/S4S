package org.launchcode.Songs4Soldiers.data;

import org.launchcode.Songs4Soldiers.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
