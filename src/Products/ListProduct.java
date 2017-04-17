package Products;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vaio on 09.02.2017.
 */

public class ListProduct {

    private static List<ObjListProduct> masProduct = new ArrayList<>();

    public ObjListProduct searchCodeByObj(int code){
        if (code <= 0) throw new IllegalArgumentException("No name in list");
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).getCodeProduct().equals(code))
                return masProduct.get(i);
        }
        throw new IllegalArgumentException("No code in list");
    }


    public double searchPriceByCode(int code, int count) {
        if ((0 > masProduct.size() - 1) || (count <= 0))
            throw new IllegalArgumentException("No code in list");
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).getCodeProduct().equals(code))
                return masProduct.get(i).getPrice() * count;
        }
        throw new IllegalArgumentException("No code in list");
    }

    public boolean searchInListForCode(int code) { //для проверки удаления
        if ((code <= 0)||(masProduct.size()==0)) return false;
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).getCodeProduct().equals(code))
                return true;
        }
        return false;
    }

    private int searchItemByName(String itemScan) {
        if (0 > masProduct.size() - 1) return -1;
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).getNameProduct().equals(itemScan.toLowerCase()))
                return i;
        }
        return -1;
    }

    private int searchItemByCode(int itemScan) {
        if (0 > masProduct.size() - 1) return -1;
        for (int i = 0; i <= masProduct.size() - 1; i++) {
            if (masProduct.get(i).getCodeProduct().equals(itemScan))
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
        int item = searchItemByName(firstName.toLowerCase());
        if (item == -1) throw new IllegalArgumentException("No name in list");
        ObjListProduct change;
        change = masProduct.get(item);
        change.setNameProduct(changeName.toLowerCase());
        masProduct.set(item, change);
    }

    public void replacePrice(String firstName, double money) {
        int item = searchItemByName(firstName);
        if (item == -1) throw new IllegalArgumentException("No name in list");
        ObjListProduct change;
        change = masProduct.get(item);
        change.setPrice(money);
        masProduct.set(item, change);
    }

    public boolean productAdd(String nameProd, int code, double price) {
        if (code <= 0
                || price < 0) return false;
        if (searchItemByCode(code) !=-1) return false; //проверка на уникальность кода
        try {
            ObjListProduct item = new ObjListProduct(nameProd.toLowerCase(), code, price);
            masProduct.add(item);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
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
        ObjListProduct a = q.searchCodeByObj(1514752);
        System.out.println(a.getNameProduct());
    }


}