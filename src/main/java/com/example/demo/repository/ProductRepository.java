package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.name LIKE %:keyword%")
    List<Product> searchByName(@Param("keyword") String keyword);

    @Query("select p from Product p where p.brand.id =:brandId")
    List<Product> searchByBrand(@Param("brandId") Integer brandId);

    @Query("select p from Product p where p.type.id =:typeId")
    List<Product> searchByType(@Param("typeId") Integer typeId);

    @Query("select p from Product p where p.type.id =:typeId AND p.brand.id =:brandId")
    List<Product> searchByTypeAndBrand(@Param("typeId") Integer typeId,@Param("brandId") Integer brandId);
}


















