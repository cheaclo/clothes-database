package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findFirstByNameIgnoreCase(String name);

    @Query(value = "select name from shop", nativeQuery = true)
    List<String> findAllOnlyName();

    List<Shop> findAllByNameStartsWithIgnoreCase(String name);
}
