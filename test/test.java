import org.junit.jupiter.api.Test;


import Products.ListProduct;

import  static org.junit.jupiter.api.Assertions.assertEquals;


public class test {
    @Test
    void testAdd(){
    ListProduct firstTry=new ListProduct();
    firstTry.productAdd("milk",1514752,405.39);
    assertEquals(false,firstTry.productAdd("milk",1514752,405.39));
    assertEquals(false,firstTry.productAdd("yte",1514752,5751.0));
    }

    @Test
    void testDelete(){
        ListProduct secondTry=new ListProduct();
        assertEquals(false,secondTry.deleteItem(4));
        secondTry.productAdd("milk",1514752,405.39);
        secondTry.productAdd("2mik",1514757,405.39);
        secondTry.productAdd("ilk",1574752,405.39);
        assertEquals(false,secondTry.deleteItem(1));
        assertEquals(true,secondTry.deleteItem(1514752));
    }

    @Test
    void testScan(){
        ListProduct testClass=new ListProduct();
        testClass.productAdd("milk",1514752,405.39);
        testClass.productAdd("potato",1514721,45.39);
        testClass.productAdd("Avokado",15141,4345.39);
        testClass.productAdd("banan",154721,41.39);
        assertEquals(405.39,testClass.searchPriceByName("milk"));
        double a=41.39*9;
        assertEquals(a,testClass.searchPriceByCode(154721,9));
        assertEquals("avokado",testClass.searchNameByCode(15141));
    }


}
