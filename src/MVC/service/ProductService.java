package MVC.service;

import MVC.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> showList();
    void add(Product product);
    Product findById(int id);
    void updateProduct(Product product,String newName, String newColor, String newUrl);


}
