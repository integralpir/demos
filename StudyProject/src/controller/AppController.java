package controller;

import model.Product;
import service.AppService;

public class AppController {
    private final AppService service;

    public AppController() {
        service = new AppService();
    }

    public Product getProduct(String article) {
        return service.getProductToUser(article);
    }
}
