package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
