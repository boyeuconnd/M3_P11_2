package MVC.service;

import MVC.model.Product;
import MVC.model.ProductList;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductList productManager = ProductList.getInstance();
    @Override
    public List<Product> showList() {
        return productManager.getList();
    }

    @Override
    public void add(Product product) {
        productManager.getList().add(product);

    }

    @Override
    public Product findById(int id) {
        for (  Product singleProduct: productManager.getList()) {
            if(singleProduct.getId()== id){
                return singleProduct;
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product product, String name, String color, String url) {
        product.setName(name);
        product.setColor(color);
        product.setImgUrl(url);
    }

    public void deleteProduct(Product product) {
        productManager.getList().remove(product);

    }
}
