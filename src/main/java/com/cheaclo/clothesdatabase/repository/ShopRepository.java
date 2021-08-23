package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findFirstByNameIgnoreCase(String name);
}
