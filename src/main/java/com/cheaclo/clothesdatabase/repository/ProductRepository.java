package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Product;
import com.cheaclo.clothesdatabase.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findFirstByHash(Integer hash);
    @Modifying
    void deleteByShopIdAndLastUpdateBefore(Long shopId, Date expiryDate);
}
