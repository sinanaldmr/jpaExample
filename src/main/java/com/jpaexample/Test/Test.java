package com.jpaexample.Test;

import com.jpaexample.jpafactory.JpaFactory;
import com.jpaexample.jpafactory.impl.JpaFactoryImpl;
import com.jpaexample.model.Brand;
import com.jpaexample.model.Category;
import com.jpaexample.model.Product;
import com.jpaexample.model.ProductDetails;
import com.jpaexample.repository.ProductRepository;
import com.jpaexample.repository.impl.ProductRepositoryImpl;

import java.util.Date;
import java.util.List;

public class Test {
    static JpaFactory jpaFactory=new JpaFactoryImpl();
    private static ProductRepository productRepository=new ProductRepositoryImpl();

    public static void main(String[] args) {
       /*
       List<Product> products=productRepository.findProducts();
        for (Product p : products
             ) {
            System.out.println( p);
        }

        Product product=productRepository.findProductById(5);
        System.out.println(product);

        List<ProductDetails> productDetailss=productRepository.findProductDetails();
        productDetailss.forEach(System.out::println);

        ProductDetails productDetails=productRepository.findProductDetailsById(5);
        System.out.println(productDetails);

        List<String> productNames=productRepository.findProductNames();
        productNames.forEach(System.out::println);

        List<Object[]> list=productRepository.findProductNameAndPrice();
        for (Object[] objects:list){
            System.out.println(objects[0]+"-"+objects[1]);
        }

        List<Product> products=productRepository.findGreatPrice(2700);
        products.forEach(System.out::println);

        List<Product> products=productRepository.findGreatAndLessPrice(0,2700);
        products.forEach(System.out::println);

        List<Product> products=productRepository.findBetweenPrice(0,2700);
        products.forEach(System.out::println);

        List<Product> products=productRepository.findLikeProductName("as");
        products.forEach(System.out::println);
        */
        List<Product> products=productRepository.findInCategoryName("Phone","COMP");
        products.forEach(System.out::println);
        

    }

    public static void insertData(){
        Brand b1=new Brand("APPLE");
        Brand b2=new Brand("ASUS");
        Brand b3=new Brand("SAMSUNG");
        Brand b4=new Brand("LG");
        Brand b5=new Brand("SONY");
        Category c1=new Category("Phone");
        Category c2=new Category("Comp");
        Category c3=new Category("TV");
        Product p1= new Product("iphone7",2500,2,b1,c1,new Date());
        Product p2=new Product("CPL2",5600,1,b2,c2,new Date());
        Product p3=new Product("HG72inç",5555,1,b4,c3,new Date());
        Product p4=new Product("qeqwe",34534,1,b5,c3,new Date());
        Product p5=new Product("asdas",345,1,b4,c1,new Date());
        Product p6=new Product("gsdgf",123,1,b5,c2,new Date());
        Product p7=new Product("cvb",568,1,b1,c1,new Date());
        Product p8=new Product("hkljk",780,1,b2,c2,new Date());
        Product p9=new Product("asdasd",567567,1,b3,c1,new Date());
        productRepository.saveBrand(b1);
        productRepository.saveBrand(b2);
        productRepository.saveBrand(b3);
        productRepository.saveBrand(b4);
        productRepository.saveBrand(b5);
        productRepository.saveCategory(c1);
        productRepository.saveCategory(c2);
        productRepository.saveCategory(c3);
        productRepository.saveProduct(p1);
        productRepository.saveProduct(p2);
        productRepository.saveProduct(p3);
        productRepository.saveProduct(p4);
        productRepository.saveProduct(p5);
        productRepository.saveProduct(p6);
        productRepository.saveProduct(p7);
        productRepository.saveProduct(p8);
        productRepository.saveProduct(p9);
    }
}
