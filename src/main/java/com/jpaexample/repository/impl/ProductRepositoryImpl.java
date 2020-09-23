package com.jpaexample.repository.impl;

import com.jpaexample.jpafactory.JpaFactory;
import com.jpaexample.jpafactory.impl.JpaFactoryImpl;
import com.jpaexample.model.Brand;
import com.jpaexample.model.Category;
import com.jpaexample.model.Product;
import com.jpaexample.model.ProductDetails;
import com.jpaexample.queries.ProductQueries;
import com.jpaexample.repository.ProductRepository;

import javax.persistence.*;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private JpaFactory jpaFactory=new JpaFactoryImpl();
    private EntityManager entityManager=jpaFactory.getEntityManager();
    private EntityTransaction transaction=jpaFactory.getTransaction();

    @Override
    public Product saveProduct(Product product) {
        this.transaction.begin();
        this.entityManager.persist(product);
        this.transaction.commit();
        return product;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        this.transaction.begin();
        this.entityManager.persist(brand);
        this.transaction.commit();
        return brand;
    }

    @Override
    public Category saveCategory(Category category) {
        this.transaction.begin();
        this.entityManager.persist(category);
        this.transaction.commit();
        return category;
    }

    @Override
    public List<Product> findProducts() {
        TypedQuery<Product> typedQuery=entityManager.createQuery(ProductQueries.findProducts,Product.class);
        List<Product> products=typedQuery.getResultList();
        return products;
    }

    @Override
    public List<Product> findProductsEntities(int firstResult, int maxResult) {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findProducts,Product.class);
        typedQuery.setFirstResult(firstResult);
        typedQuery.setMaxResults(maxResult);
        List<Product> products=typedQuery.getResultList();
        return products;
    }

    @Override
    public Product findProductById(int productId) {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findProductById,Product.class);
        typedQuery.setParameter("productId",productId);
        Product product=typedQuery.getSingleResult();
        return product;
    }

    @Override
    public List<ProductDetails> findProductDetails() {
        TypedQuery<ProductDetails> typedQuery=this.entityManager.createQuery(ProductQueries.findProductDetails,ProductDetails.class);
        List<ProductDetails> productDetails=typedQuery.getResultList();
        return productDetails;
    }

    @Override
    public ProductDetails findProductDetailsById(int productId) {
        TypedQuery<ProductDetails> typedQuery=this.entityManager.createQuery(ProductQueries.findProductDetailsById,ProductDetails.class);
        typedQuery.setParameter("productId",productId);
        ProductDetails productDetails=typedQuery.getSingleResult();
        return productDetails;
    }

    @Override
    public List<String> findProductNames() {
        TypedQuery<String> typedQuery=this.entityManager.createQuery(ProductQueries.findProductNames,String.class);
        List<String> productNames=typedQuery.getResultList();
        return productNames;
    }

    @Override
    public List<Object[]> findProductNameAndPrice() {
        Query query=this.entityManager.createQuery(ProductQueries.findProductNamePrice);
        List<Object[]> productNameAndPrice=query.getResultList();
        return productNameAndPrice;
    }

    @Override
    public List<Product> findGreatPrice(double unitprice) {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findGreatPrice,Product.class);
        typedQuery.setParameter("unitPrice",unitprice);
        List<Product> products=typedQuery.getResultList();
        return products;
    }

    @Override
    public List<Product> findGreatAndLessPrice(double minUnitPrice, double maxUnitPrice) {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findGreatLessPrice,Product.class);
        typedQuery.setParameter("minUnitPrice",minUnitPrice);
        typedQuery.setParameter("maxUnitPrice",maxUnitPrice);
        List<Product> products=typedQuery.getResultList();
        return products;
    }

    @Override
    public List<Product> findBetweenPrice(double minUnitPrice, double maxUnitPrice) {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findBetweenPrice,Product.class);
        typedQuery.setParameter("minUnitPrice",minUnitPrice);
        typedQuery.setParameter("maxUnitPrice",maxUnitPrice);
        List<Product> products=typedQuery.getResultList();
        return products;
    }

    @Override
    public List<Product> findLikeProductName(String productName) {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findLikeProductName,Product.class);
        typedQuery.setParameter("productName","%"+productName+"%");
        List<Product> products=typedQuery.getResultList();
        return products;
    }

    @Override
    public List<Product> findInCategoryName(String categoryName1, String categoryName2) {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findInCategoryName,Product.class);
        typedQuery.setParameter("categoryName",categoryName1);
        typedQuery.setParameter("categoryName2",categoryName2);
        List<Product> products=typedQuery.getResultList();
        return products;
    }

    @Override
    public List<Product> findAllProducts(int categoryId) {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findAllProducts,Product.class);
        typedQuery.setParameter("categoryId",categoryId);
        List<Product> products=typedQuery.getResultList();
        return products;
    }

    @Override
    public List<Object[]> findFunctionsPrice() {
        Query query=this.entityManager.createQuery(ProductQueries.findFunctionsPrice);
        List<Object[]> findFunctionsPrice=query.getResultList();
        return findFunctionsPrice;
    }

    @Override
    public List<Object[]> findGroupByCategory() {
        Query query=this.entityManager.createQuery(ProductQueries.findGroupByCategory);
        List<Object[]> groupByCategory=query.getResultList();
        return groupByCategory;
    }

    @Override
    public List<Object[]> findGroupByHavingCategory(double unitPrice) {
        Query query=this.entityManager.createQuery(ProductQueries.findGroupByHavingCategory);
        List<Object[]> groupByHavingCategory=query.getResultList();
        return groupByHavingCategory;
    }

    @Override
    public List<Product> findOrderByPrice() {
        TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findOrderByPrice,Product.class);
        List<Product> products=typedQuery.getResultList();
        return products;
    }
}
