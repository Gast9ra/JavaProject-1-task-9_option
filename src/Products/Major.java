package Products;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vaio on 09.02.2017.
 */

public class Major {

    public static List<listProduct> masProduct = new ArrayList<listProduct>();

    static class listProduct {
        String nameProduct;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            listProduct that = (listProduct) o;

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

        Integer codeProduct;
        Double Price;
    }

    public String searchNameByCode(int itemScan){
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).codeProduct == itemScan) return masProduct.get(i).nameProduct;
        }
        return "";
    }

    public int scanItemByName(String itemScan) {
        if (0 > masProduct.size() - 1) return -1;
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).nameProduct == itemScan.toLowerCase()) return i;
        }
        return -1;
    }

    public double scanPriceByName(String itemSearch) {
        if (0 > masProduct.size() - 1) return -1.0;
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).nameProduct.toLowerCase() == itemSearch.toLowerCase()) return masProduct.get(i).Price;
        }
        return -1.0;
    }

    public double searchPriceByCode(int code, int count) {
        if (0 > masProduct.size() - 1) return -1.0;
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).codeProduct == code) return masProduct.get(i).Price * count;
        }
        return -1.0;
    }

    public boolean deleteItem(int numberItem) {
        try {
            masProduct.remove(numberItem);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public String showItemName(int numberInMas) {
        try {
            return masProduct.get(numberInMas).nameProduct;
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }

    public int showItemCode(int numberInMas) {
        try {
            return masProduct.get(numberInMas).codeProduct;
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    public double showItemPrice(int numberInMas) {
        try {
            return masProduct.get(numberInMas).Price;
        } catch (IndexOutOfBoundsException e) {
            return -1.0;
        }
    }

    public void replaceName(int itemNumber, String name) {
        try {
            listProduct change;
            change = masProduct.get(itemNumber);
            change.nameProduct = name;
            masProduct.set(itemNumber, change);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: ");
        }
    }

    public void replacePrice(int itemNumber, double money) {
        try {
            listProduct change;
            change = masProduct.get(itemNumber);
            change.Price = money;
            masProduct.set(itemNumber, change);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: ");
        }
    }

    public void replaceCode(int itemNumber, int itemCode) {
        try {
            listProduct change;
            change = masProduct.get(itemNumber);
            change.codeProduct = itemCode;
            masProduct.set(itemNumber, change);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: ");
        }
    }


    public int productAdd(String nameProd, int code, double price) {
        if (code < 0 || price < 0) return -1;
        if (scanItemByName(nameProd)!=-1 || searchPriceByCode(code,1)!=-1) return -1;
        if (checkWithRegExp(nameProd)!=true) return -1;
        listProduct item = new listProduct();
        item.nameProduct = nameProd.toLowerCase();
        item.codeProduct = code;
        item.Price = price;
        masProduct.add(item);
        return 1;
    }

    private  boolean checkWithRegExp(String productNameString){
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
        Major q = new Major();
        q.productAdd("milk", 1514752, 405.39);
        q.showItemName(2);
    }


}