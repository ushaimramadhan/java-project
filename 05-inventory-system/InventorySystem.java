import java.util.HashMap;
import java.util.Map;

class Product {
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

class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

class InventoryManager {
    private Map<String, Product> storage = new HashMap<>();

    public void addProduct(Product p) {
        storage.put(p.getId(), p);
    }

    public void reduceStock(String id, int quantity) throws InsufficientStockException {
        if (!storage.containsKey(id)) {
            System.out.println("Barang tidak ditemukan!");
            return;
        }

        Product barang = storage.get(id);
        int stockSaatIni = barang.getStock();
        
        if (stockSaatIni < quantity) {
            throw new InsufficientStockException("stok " + barang.getName() + " kurang!");
        
        } else {
            int sisaStock = stockSaatIni - quantity;
            barang.setStock(sisaStock);
            System.out.println("Behasil mengurangi stok " + barang.getName());
        }
    }

    public void printAllProducts() {
        System.out.println("LIST BARANG DI GUDANG");

        for (Product p : storage.values()) {
            System.out.println(p);
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product("A1", "Laptop Gaming", 15000000, 5));
        manager.addProduct(new Product("B1", "Mouse Wireless", 150000, 10));

        try {
            System.out.println("Transaksi 1: Beli Mouse 2 buah");
            manager.reduceStock("B1", 2);

            System.out.println("\nTransaksi 2: Beli Laptop Gaming");
            manager.reduceStock("A1", 10);
        } catch (InsufficientStockException e){
            System.out.println("TRANSAKSI GAGAL: " + e.getMessage());
        }

        System.out.println("\n=== Stok Akhir ===");
        manager.printAllProducts();
    }
}