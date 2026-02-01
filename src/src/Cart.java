import java.util.*;

public class Cart {
    private HashMap<Integer, Integer> items; // ProductID -> Quantity
    private Inventory inventory;

    public Cart(Inventory inventory) {
        this.items = new HashMap<>();
        this.inventory = inventory;
    }

    public void addToCart(int id, int qty) {
        Product p = inventory.getProduct(id);
        if(p == null) {
            System.out.println("Product not found.");
            return;
        }
        if(p.getQuantity() < qty) {
            System.out.println("Insufficient stock.");
            return;
        }
        items.put(id, items.getOrDefault(id, 0) + qty);
        System.out.println(qty + " x " + p.getName() + " added to cart.");
    }

    public void removeFromCart(int id) {
        if(items.containsKey(id)) {
            items.remove(id);
            System.out.println("Product removed from cart.");
        } else {
            System.out.println("Product not in cart.");
        }
    }

    public void viewCart() {
        if(items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double total = 0;
        System.out.println("Your Cart:");
        for(int id : items.keySet()) {
            Product p = inventory.getProduct(id);
            int qty = items.get(id);
            System.out.println(p.getName() + " x " + qty + " = $" + (p.getPrice() * qty));
            total += p.getPrice() * qty;
        }
        System.out.println("Total: $" + total);
    }

    public void checkout() {
        if(items.isEmpty()) {
            System.out.println("Cart is empty. Cannot checkout.");
            return;
        }
        for(int id : items.keySet()) {
            Product p = inventory.getProduct(id);
            int qty = items.get(id);
            p.setQuantity(p.getQuantity() - qty);
        }
        items.clear();
        System.out.println("Checkout successful! Inventory updated.");
    }
}
