public class Cart {
    private final String cartId;
    private final double[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.itemPrices = new double[capacity];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price <= 0) {
            System.out.println("Price must be greater than zero.");
            return;
        }

        if (itemCount < itemPrices.length) {
            itemPrices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Cart capacity reached!");
        }
    }

    // Total calculated dynamically on request by traversing the private array
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}