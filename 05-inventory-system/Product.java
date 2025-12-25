import java.util.HashMap;
import java.util.Map;

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

public class InventoryManager {
    private Map<String, Product> storage = new HashMap<>();

    public void addProduct(Product p) {
        storage.put(p.getId(), p);
    }

    public void reduceStock(String id, int quantity) throws InsufficientStockException{
        Product barang = storage.get(id);
        int stockSaatIni = barang.getStock();
        int sisaStock = stockSaatIni - quantity;

        if (!storage.containsKey(id)) {
            System.out.println("Barang tidak ditemukan!");
            return;
        } else if (stockSaatIni < quantity) {
            throw new InsufficientStockException("stok " + barang.getName() + " kurang!");
        } else {
            sisaStock.setStock();

            System.out.println("Behasil mengurangi stok " + barang.getName());
        }


    }
}