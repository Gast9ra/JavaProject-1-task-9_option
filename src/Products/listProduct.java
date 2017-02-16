package Products;

/**
 * Created by Vaio on 14.02.2017.
 */
public class listProduct {
     String nameProduct;
     String codeProduct;
     String price;

    public listProduct(String nameProduct,
                       String codeProduct,
                       String price) {
        this.nameProduct = nameProduct;
        this.codeProduct = codeProduct;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}


