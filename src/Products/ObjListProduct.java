package Products;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gast9ra on 22.03.2017.
 */
public class ObjListProduct {
    private String nameProduct;
    private Integer codeProduct;
    private Double Price;

    ObjListProduct(String inName,int inCode,double inPrice){
        if (!checkWithRegExp(inName))
            throw new IllegalArgumentException("name not valid");
        this.nameProduct=inName;
        this.codeProduct=inCode;
        this.Price=inPrice;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        if (!checkWithRegExp(nameProduct))
            throw new IllegalArgumentException("name not valid");
        this.nameProduct = nameProduct;
    }

    public Integer getCodeProduct() {
        return codeProduct;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjListProduct)) return false;

        ObjListProduct that = (ObjListProduct) o;

        if (!getNameProduct().equals(that.getNameProduct())) return false;
        if (!getCodeProduct().equals(that.getCodeProduct())) return false;
        return getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        int result = getNameProduct().hashCode();
        result = 31 * result + getCodeProduct().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }

    private boolean checkWithRegExp(String productNameString) { //проверка на валидность имени
        Pattern p = Pattern.compile("^[A-Za-z0-9]+\\w");
        Matcher m = p.matcher(productNameString);
        return m.matches();
    }

}
