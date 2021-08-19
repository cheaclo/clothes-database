package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

}
