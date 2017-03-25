package Products;

/**
 * Created by Gast9ra on 22.03.2017.
 */
public class ObjListProduct {
    String nameProduct;
    Integer codeProduct;
    Double Price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjListProduct)) return false;

        ObjListProduct that = (ObjListProduct) o;

        if (!nameProduct.equals(that.nameProduct)) return false;
        if (!codeProduct.equals(that.codeProduct)) return false;
        return Price.equals(that.Price);
    }

    @Override
    public int hashCode() {
        int result = nameProduct.hashCode();
        result = 31 * result + codeProduct.hashCode();
        result = 31 * result + Price.hashCode();
        return result;
    }
}
