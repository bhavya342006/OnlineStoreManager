import java.util.*;

public class Inventory {
    private HashMap<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product p) {
        products.put(p.getId(), p);
        System.out.println("Product added successfully.");
    }

    public void removeProduct(int id) {
        if(products.containsKey(id)) {
            products.remove(id);
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void updateProductQuantity(int id, int qty) {
        if(products.containsKey(id)) {
            Product p = products.get(id);
            p.setQuantity(qty);
            System.out.println("Quantity updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void viewAllProducts() {
        if(products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for(Product p : products.values()) {
            System.out.println(p);
        }
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public Product searchByName(String name) {
        for(Product p : products.values()) {
            if(p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public List<Product> getAllProductsSortedByPrice() {
        List<Product> list = new ArrayList<>(products.values());
        list.sort(Comparator.comparingDouble(Product::getPrice));
        return list;
    }
}
