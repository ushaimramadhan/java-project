public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int ubah) {
        stock = ubah;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "Name: " + this.name + "Price: " + this.price + "Stock: " + this.stock;
    }
}

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}