package models;

public class CartDetail {
    private String cartId;
    private String productId;
    private String productName;
    private int quantity;
    private int price;
    private boolean status;
    
    public CartDetail() {
		// TODO Auto-generated constructor stub
	}

    public CartDetail(String cartId, String productId, String productName, int quantity, int price, boolean status) {
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.status = status;    
    }

	public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
