package MVC.model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private List<Product> productList = new ArrayList<Product>();
    private ProductList(){
        Product product1 = new Product(1,"Iphone 11","Green");
        product1.setImgUrl("https://images.fpt.shop/unsafe/fit-in/192x192/filters:quality(90):fill(white)/cdn.fptshop.com.vn/Uploads/Originals/2019/9/11/637037651956109900_11-chung.png");
        productList.add(product1);
        productList.add(new Product(2,"Iphone 11 pro","White"));
        productList.add(new Product(3,"Iphone 11 pro max","Silver"));
        productList.add(new Product(4,"Iphone xs max","Gray"));
        productList.add(new Product(5,"Iphone XS","Black"));
        productList.get(1).setImgUrl("https://images.fpt.shop/unsafe/fit-in/192x192/filters:quality(90):fill(white)/cdn.fptshop.com.vn/Uploads/Originals/2019/9/11/637037687757921048_11-pro-max-chung.png");
        productList.get(2).setImgUrl("https://images.fpt.shop/unsafe/fit-in/192x192/filters:quality(90):fill(white)/cdn.fptshop.com.vn/Uploads/Originals/2019/9/11/637037687757921048_11-pro-max-chung.png");
        productList.get(3).setImgUrl("https://images.fpt.shop/unsafe/fit-in/192x192/filters:quality(90):fill(white)/cdn.fptshop.com.vn/Uploads/Originals/2018/10/12/636749593270587915_iphoneXS-1o.png");
        productList.get(4).setImgUrl("https://images.fpt.shop/unsafe/fit-in/192x192/filters:quality(90):fill(white)/cdn.fptshop.com.vn/Uploads/Originals/2018/10/12/636749593270587915_iphoneXS-1o.png");

    }
    private static ProductList instance;
    public static ProductList getInstance(){
        if(instance==null){
            instance =  new ProductList();
        }
        return instance;
    }
    public List<Product> getList(){
        return productList;
    }


}
