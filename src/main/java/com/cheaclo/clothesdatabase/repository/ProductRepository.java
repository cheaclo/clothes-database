package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findFirstByHash(Integer hash);
    @Modifying
    void deleteByShopIdAndLastUpdateBefore(Long shopId, Date expiryDate);

    @Query(value = "select * " +
            "from product " +
            "where lower(title) like CONCAT('%', lower(:title), '%') and shop_id in\n" +
            "                                              (select shop_id from shop where lower(name) in (:shops))" +
            "order by title", nativeQuery = true)
    List<Product> findAllByNameAndShop(String title, List<String> shops);

    @Query(value = "select *" +
            "from product " +
            "where product_type_id=:typeId", nativeQuery = true)
    List<Product> findAllByType(Long typeId);

    @Query(value = "select *\n" +
                    "from product\n" +
                    "where product_type_id=:typeId and id in (\n" +
                    "    select product_id\n" +
                    "    from product_categories\n" +
                    "    where categories_id=:categoryId)", nativeQuery = true)
    List<Product> findAllByTypeAndCategories(Long typeId, Long categoryId);

    List<Product> findAllByShopId(Long shopId);
}
