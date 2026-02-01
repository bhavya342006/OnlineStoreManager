import java.util.Scanner;

public class StoreManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Cart cart = new Cart(inventory);

        while(true) {
            System.out.println("\n--- Online Store Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. View All Products");
            System.out.println("5. Search Product");
            System.out.println("6. Add to Cart");
            System.out.println("7. Remove from Cart");
            System.out.println("8. View Cart");
            System.out.println("9. Checkout");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    System.out.print("Product ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Price: "); double price = sc.nextDouble();
                    System.out.print("Quantity: "); int qty = sc.nextInt();
                    Product p = new Product(id, name, price, qty);
                    inventory.addProduct(p);
                    break;
                case 2:
                    System.out.print("Product ID to remove: "); inventory.removeProduct(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Product ID to update: "); int uid = sc.nextInt();
                    System.out.print("New Quantity: "); int newQty = sc.nextInt();
                    inventory.updateProductQuantity(uid, newQty);
                    break;
                case 4:
                    inventory.viewAllProducts();
                    break;
                case 5:
                    System.out.print("Search by Name: "); sc.nextLine();
                    Product search = inventory.searchByName(sc.nextLine());
                    System.out.println(search != null ? search : "Product not found.");
                    break;
                case 6:
                    System.out.print("Product ID to add to cart: "); int cid = sc.nextInt();
                    System.out.print("Quantity: "); int cqty = sc.nextInt();
                    cart.addToCart(cid, cqty);
                    break;
                case 7:
                    System.out.print("Product ID to remove from cart: "); cart.removeFromCart(sc.nextInt());
                    break;
                case 8:
                    cart.viewCart();
                    break;
                case 9:
                    cart.checkout();
                    break;
                case 0:
                    System.out.println("Exiting store. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
