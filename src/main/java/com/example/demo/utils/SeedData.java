package com.example.demo.utils;

import com.example.demo.domain.*;
import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class SeedData {
    /*
Bu servis sınıfı, başlangıç verilerini ekleyen bir seedDatabase metodunu içerir. Bu metodun @Transactional annotation'ı, metodu bir transaksiyon içinde çalıştırmasını sağlar.
*/
    private final ProductRepository productRepository;
    private final TypeRepository productTypeRepository;
    private final BrandRepository productBrandRepository;
    //private final UserRepository userRepository;
    //private final AddressRepository addressRepository;

    @Autowired
    public SeedData(ProductRepository productRepository, TypeRepository productTypeRepository,
                    BrandRepository productBrandRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.productBrandRepository = productBrandRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public void seedData() {
        seedBrands();
        seedTypes();
        seedProducts();
        //seedAddress();
        //seedUsers();
    }

    /*private void seedUsers(){
        List<User> users = Arrays.asList(
                new User(1,"mustafa","mustafa@hotmail.com",passwordEncoder().encode("123456"),addressRepository.getById(1)),
                new User(2,"musa","musa@hotmail.com",passwordEncoder().encode("123456"),addressRepository.getById(2)),
                new User(3,"hasan","hasan@hotmail.com",passwordEncoder().encode("123456"),addressRepository.getById(3))
        );

        for(User user: users){
            Address address = addressRepository.findById(user.getAddress().getId()).orElse(null);

            user.setAddress(address);

            userRepository.save(user);
        }

        userRepository.saveAll(users);

    }*/

    /*private void seedAddress(){
        List<Address> addresses = Arrays.asList(
                new Address(1,"mustafa","güler","bora sokak","istanbul","beykoz","3000"),
                new Address(2,"musa","güler","çatal sokak","istanbul","ümraniye","3001"),
                new Address(3,"hasan","güler","boğa sokak","istanbul","kadiköy","3002")
        );
        addressRepository.saveAll(addresses);
    }*/

    private void seedBrands() {
        List<Brand> brands = Arrays.asList(
                new Brand(1,"Boards"),
                new Brand(2,"Hats"),
                new Brand(3,"Boots"),
                new Brand(4,"Gloves")
        );
        productBrandRepository.saveAll(brands);
    }

    private void seedTypes() {
        List<Type> types = Arrays.asList(
                new Type(1,"Angular"),
                new Type(2,"NetCore"),
                new Type(3,"VS Code"),
                new Type(4,"React"),
                new Type(5,"Typescript"),
                new Type(6,"Redis")
        );
        productTypeRepository.saveAll(types);
    }

    private void seedProducts() {
        List<Product> products = Arrays.asList(
                new Product(1,"Angular Speedster Board 2000", "Lorem ipsum...", new BigDecimal(150), "/images/products/sb-ang1.png", productTypeRepository.getById(1), productBrandRepository.getById(1)),
                new Product(2,"Green Angular Board 3000", "Nunc viverra...", new BigDecimal(150), "/images/products/sb-ang2.png", productTypeRepository.getById(1), productBrandRepository.getById(1)),
                new Product(3,"Core Board Speed Rush 3", "Suspendisse dui...", new BigDecimal(180), "/images/products/sb-core1.png", productTypeRepository.getById(1), productBrandRepository.getById(2)),
                new Product(4,"Net Core Super Board", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(300), "/images/products/sb-core2.png", productTypeRepository.getById(1), productBrandRepository.getById(2)),
                new Product(5,"React Board Super Whizzy Fast", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(400), "/images/products/sb-react1.png", productTypeRepository.getById(1), productBrandRepository.getById(4)),
                new Product(6,"Typescript Entry Board", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(500), "/images/products/sb-ts1.png", productTypeRepository.getById(1), productBrandRepository.getById(5)),
                new Product(7,"Core Blue Hat", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(140), "/images/products/hat-core1.png", productTypeRepository.getById(2), productBrandRepository.getById(2)),
                new Product(8,"Green React Woolen Hat", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150), "/images/products/hat-react1.png", productTypeRepository.getById(2), productBrandRepository.getById(4)),
                new Product(9,"Purple React Woolen Hat", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150), "/images/products/hat-react2.png", productTypeRepository.getById(2), productBrandRepository.getById(4)),
                new Product(10,"Blue Code Gloves", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150), "/images/products/glove-code1.png", productTypeRepository.getById(4), productBrandRepository.getById(3)),
                new Product(11,"Green Code Gloves", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150), "/images/products/glove-code2.png", productTypeRepository.getById(4), productBrandRepository.getById(3)),
                new Product(12,"Purple React Gloves", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150), "/images/products/glove-react1.png", productTypeRepository.getById(4), productBrandRepository.getById(4)),
                new Product(13,"Green React Gloves", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150), "/images/products/glove-react2.png", productTypeRepository.getById(4), productBrandRepository.getById(4)),
                new Product(14,"Redis Red Boots", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150), "/images/products/boot-redis1.png", productTypeRepository.getById(3), productBrandRepository.getById(6)),
                new Product(15,"Core Red Boots", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150.99), "/images/products/boot-core2.png", productTypeRepository.getById(3), productBrandRepository.getById(2)),
                new Product(16,"Core Purple Boots", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(199.99), "/images/products/boot-core1.png", productTypeRepository.getById(3), productBrandRepository.getById(2)),
                new Product(17,"Angular Purple Boots", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(150), "/images/products/boot-ang2.png", productTypeRepository.getById(3), productBrandRepository.getById(1)),
                new Product(18,"Angular Blue Boots", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci", new BigDecimal(170), "/images/products/boot-ang1.png", productTypeRepository.getById(3), productBrandRepository.getById(1))
                // Diğer ürünleri ekleyin
        );

        for (Product product : products) {
            // Eğer ürün daha önce eklenmemişse ekle
            //if (productRepository.getById(product.getId()) != null) {
            Brand brand = productBrandRepository.findById(product.getBrand().getId()).orElse(null);
            Type type = productTypeRepository.findById(product.getType().getId()).orElse(null);

            product.setBrand(brand);
            product.setType(type);

            productRepository.save(product);
            //}
        }
        productRepository.saveAll(products);
    }
}
