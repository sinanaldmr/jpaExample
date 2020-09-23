package com.jpaexample.repository;

import com.jpaexample.model.Brand;
import com.jpaexample.model.Category;
import com.jpaexample.model.Product;
import com.jpaexample.model.ProductDetails;

import java.util.List;

public interface ProductRepository {
    Product saveProduct(Product product);
    Brand saveBrand(Brand brand);
    Category saveCategory(Category category);
    List<Product> findProducts();
    List<Product> findProductsEntities(int firstResult, int maxResult);
    Product findProductById(int productId);
    List<ProductDetails> findProductDetails();
    ProductDetails findProductDetailsById(int productId);
    List<String> findProductNames();
    List<Object[]> findProductNameAndPrice();
    List<Product> findGreatPrice(double unitprice);
    List<Product> findGreatAndLessPrice(double minUnitPrice, double maxUnitPrice);
    List<Product> findBetweenPrice(double minUnitPrice, double maxUnitPrice);
    List<Product> findLikeProductName(String productName);
    List<Product> findInCategoryName(String categoryName1, String categoryName2);
    List<Product> findAllProducts(int categoryId);
    List<Object[]> findFunctionsPrice();
    List<Object[]> findGroupByCategory();
    List<Object[]> findGroupByHavingCategory(double unitPrice);
    List<Product> findOrderByPrice();
}
