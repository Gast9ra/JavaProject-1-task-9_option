package Products;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaio on 14.02.2017.
 */

public class listProduct22 {
     String nameProduct;
     String codeProduct;
     String price;



    public listProduct22(String nameProduct,
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
        System.gc();
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
        System.gc();
    }

    public void setPrice(String price) {
        this.price = price;
        System.gc();
    }


}


