package service;

import model.Product;
import repository.ProductRepository;

public class AppService {
    private final ProductRepository repository;

    public AppService() {
        repository = new ProductRepository();
    }

    public Product getProductToUser(String article) {
        Product product = repository.findProductByArticle(article);

        int newCount = product.getCount() - 1;
        product.setCount(newCount);

        return product;
    }
}
