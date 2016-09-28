package smell;
 
class Item {
    protected int productId;
    private int ImageID;
    private int qty;
    private int Unitprice;
 
    public Item(int prodID, int ImageID, int inQty) {
        productId = prodID;
        this.ImageID = ImageID;
        qty = inQty;        
    }
 
    int getProductID() {
        return productId;
    }
 
    int getImageID() {
        return ImageID;
    }
 
    int getQuantity() {
        return qty;
    }
 
    int getUnitPrice() {
        return Unitprice;
    }
 
    public void setProductID(int id) {
        productId = id;
    }
 
    public void setImageID(int ID) {
        ImageID = ID;
    }
 
    public void setQty(int qty) {
        this.qty = qty;
    }
 
    public void setUnitPrice(int i) {
        Unitprice = i;
    }
}
