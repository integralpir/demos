package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<>();
        productList.add(new Product("product1", 100.00f, "description1", "123art", "url", 1));
        productList.add(new Product("product2", 110.00f, "description2", "124art", "url", 2));
        productList.add(new Product("product3", 120.00f, "description3", "125art", "url", 3));
        productList.add(new Product("product4", 130.00f, "description4", "126art", "url", 4));
        productList.add(new Product("product5", 140.00f, "description5", "127art", "url", 5));
    }

    public int getCountProduct(String article) {
        Product product = getProductByArticle(article);
        return product.getCount();
    }

    public Product findProductByArticle(String article) {
        return getProductByArticle(article);
    }

    private Product getProductByArticle(String article) {
        Product result = null;

        for (Product product : productList) {
            if (article.equals(product.getArticle())) {
                result = product;
            }
        }

        if (result == null) {
            result = new Product("undefined", 0.00f, "undefined",
                    "undefined", null, -1);
        }

        return result;
    }
}
