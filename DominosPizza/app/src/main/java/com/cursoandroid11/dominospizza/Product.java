package com.cursoandroid11.dominospizza;

public class Product {
    private String productoTitle;
    private String productDescription;
    private String productPrice;
    private String productImg;

    public Product(String productoTitle,String productDescription,String productPrice,String productImg){
        setProductoTitle(productoTitle);
        setProductDescription(productDescription);
        setProductPrice(productPrice);
        setProductImg(productImg);
    }

    public String getProductoTitle() {
        return productoTitle;
    }

    public void setProductoTitle(String productoTitle) {
        this.productoTitle = productoTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
