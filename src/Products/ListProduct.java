package Products;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vaio on 09.02.2017.
 */

public class ListProduct {

    private static List<ObjListProduct> masProduct = new ArrayList<ObjListProduct>();


    public String searchNameByCode(int itemScan) {
        if (itemScan <= 0) throw new IllegalArgumentException("No name in list");
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).codeProduct.equals(itemScan))
                return masProduct.get(i).nameProduct;
        }
        throw new IllegalArgumentException("No code in list");
    }


    public double searchPriceByName(String itemSearch) {
        if (0 > masProduct.size() - 1)
            throw new IllegalArgumentException("No name in list");
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).nameProduct.toLowerCase()
                    .equals(itemSearch.toLowerCase()))
                return masProduct.get(i).Price;
        }
        throw new IllegalArgumentException("No name in list");
    }

    public double searchPriceByCode(int code, int count) {
        if ((0 > masProduct.size() - 1) || (count <= 0))
            throw new IllegalArgumentException("No code in list");
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).codeProduct.equals(code))
                return masProduct.get(i).Price * count;
        }
        throw new IllegalArgumentException("No code in list");
    }

    private int searchItemByName(String itemScan) {
        if (0 > masProduct.size() - 1) return -1;
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).nameProduct.equals(itemScan.toLowerCase()))
                return i;
        }
        return -1;
    }

    private int searchItemByCode(int itemScan) {
        if (0 > masProduct.size() - 1) return -1;
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).codeProduct.equals(itemScan))
                return i;
        }
        return -1;
    }

    public boolean deleteItem(int code){
        try{
            int numInMas = searchItemByCode(code);
            masProduct.remove(numInMas);
        }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    public void replaceName(String firstName, String changeName) {
        int item = searchItemByName(firstName);
        if (item == -1) throw new IllegalArgumentException("No name in list");
        ObjListProduct change;
        change = masProduct.get(item);
        change.nameProduct = changeName;
        masProduct.set(item, change);
    }

    public void replacePrice(String firstName, double money) {
        int item = searchItemByName(firstName);
        if (item == -1) throw new IllegalArgumentException("No name in list");
        ObjListProduct change;
        change = masProduct.get(item);
        change.Price = money;
        masProduct.set(item, change);
    }

    public void replaceCode(String firstName, int itemCode) {
        int item = searchItemByName(firstName);
        if (item == -1) throw new IllegalArgumentException("No name in list");
        ObjListProduct change;
        change = masProduct.get(item);
        change.codeProduct = itemCode;
        masProduct.set(item, change);
    }


    public boolean productAdd(String nameProd, int code, double price) {
        if (code <= 0
                || price < 0) return false;
        if (searchItemByCode(code) !=-1) return false; //проверка на уникальность кода
        if (!checkWithRegExp(nameProd)) return false;
        ObjListProduct item = new ObjListProduct();
        item.nameProduct = nameProd.toLowerCase();
        item.codeProduct = code;
        item.Price = price;
        masProduct.add(item);
        return true;

    }

    private boolean checkWithRegExp(String productNameString) { //проверка на валидность имени
        Pattern p = Pattern.compile("^[A-Za-z0-9]+\\w");
        Matcher m = p.matcher(productNameString);
        return m.matches();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String args[]) {
        ListProduct q = new ListProduct();
        q.productAdd("milk", 1514752, 405.39);

    }


}