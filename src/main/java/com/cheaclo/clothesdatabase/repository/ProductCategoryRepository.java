package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findFirstByNameIgnoreCase(String name);

    @Query(value = "select count(*)\n" +
            "from product_categories\n" +
            "where categories_id=:category_id and product_id in (\n" +
            "        select id from product where product_type_id=:type_id\n" +
            "    )", nativeQuery = true)
    Long countByCategoryIdAndTypeId(Long category_id, Long type_id);
}
