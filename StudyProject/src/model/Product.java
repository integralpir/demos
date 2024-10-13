package model;

public class Product {
    private String title;
    private float price;
    private String description;
    private String article;
    private String imageUrl;
    private int count;

    public Product(String title, float price, String description, String article, String imageUrl, int count) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.article = article;
        this.imageUrl = imageUrl;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", article='" + article + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
