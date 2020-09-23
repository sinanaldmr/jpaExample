package com.jpaexample.queries;

public class ProductQueries {
    public static final String findProducts="SELECT p FROM Product p";
    public static final String findProductById="SELECT p FROM Product p WHERE p.productId=:productId";
    public static final String findProductDetails="SELECT new com.jpaexample.model.ProductDetails" +
            "(p.productName,p.unitPrice,p.avaible,b.brandName,c.categoryName) FROM Product p " +
            "LEFT JOIN p.brand b " +
            "LEFT JOIN p.category c";
    public static final String findProductDetailsById="SELECT new com.jpaexample.model.ProductDetails" +
            "(p.productName, p.unitPrice, p.avaible, b.brandName, c.categoryName) FROM Product p " +
            "LEFT JOIN p.brand b " +
            "LEFT JOIN p.category c WHERE p.productId=:productId";
    public static final String findProductNames="SELECT p.productName FROM Product p";
    public static final String findProductNamePrice="SELECT p.productName, p.unitPrice FROM Product p";
    public static final String findGreatPrice="SELECT p FROM Product p WHERE p.unitPrice>:unitPrice";
    public static final String findGreatLessPrice="SELECT p FROM Product p WHERE p.unitPrice>:minUnitPrice " +
            "AND p.unitPrice <: maxUnitPrice";
    public static final String findBetweenPrice="SELECT p FROM Product p WHERE p.unitPrice " +
            "BETWEEN :minUnitPrice AND :maxUnitPrice";
    public static final String findLikeProductName="SELECT p FROM Product p WHERE p.productName LIKE :productName";
    public static final String findInCategoryName="SELECT p FROM Product p " +
            "LEFT JOIN p.category c WHERE c.categoryName IN (:categoryName, :categoryName2)";
    public static final String findAllProducts="SELECT p FROM Product p WHERE p.unitPrice> ALL" +
            "(SELECT p2.unitPrice FROM Product p2 WHERE p2.category.categoryId=:categoryId) ";
    public static final String findFunctionsPrice="SELECT " +
            "AVG(p.unitPrice), SUM(p.unitPrice), MAX(p.unitPrice), MIN(p.unitPrice), COUNT(p)" +
            "FROM Product p";
    public static final String findGroupByCategory="SELECT p.category.categoryName AVG(p.unitPrice) FROM Product p " +
            "GROUP BY p.category.categoryName";
    public static final String findGroupByHavingCategory="SELECT p.category.categoryName AVG(p.unitPrice) FROM Product p " +
            "GROUP BY p.category.categoryName HAVING AVG(p.unitPrice)>:unitPrice";
    public static final String findOrderByPrice="SELECT p FROM Product p ORDER BY p.unitPrice DESC";

}
