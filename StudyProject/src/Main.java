import controller.AppController;

import java.util.Scanner;

//Супер-черновая штука для базового понимания архитектуры приложений
//Если хотите побаловаться, то пожалуйста, но чего-то суперкалссного от сюда не выйдет)

public class Main {
    private static final AppController controller = new AppController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String article = scanner.next();

        System.out.println(controller.getProduct(article).toString());
    }
}