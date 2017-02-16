package Products;


import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by Vaio on 09.02.2017.
 */
public class major {

    public static void main (String args[]){
        listProduct a= new listProduct("tghr","rsmwks","1027");
        System.out.println(a.getCodeProduct());
        System.out.println(a.getNameProduct());
        System.out.println(a.getPrice());
        a.setCodeProduct("165141656456465456");
        System.out.println(a.getCodeProduct());
    }

    public void productAdd(String nameProd,String code,double price){

    }
}

