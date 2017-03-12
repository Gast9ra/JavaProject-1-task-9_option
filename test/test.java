import org.junit.jupiter.api.Test;


import Products.Major;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class test {
    @Test
    void testAdd(){
    Major firstTry=new Major();
    firstTry.productAdd("milk",1514752,405.39);
    assertEquals(-1,firstTry.productAdd("milk",1514752,405.39));
    assertEquals(-1,firstTry.productAdd("yte",1514752,5751.0));
    }

    @Test
    void testDelete(){
        Major secondTry=new Major();
        assertEquals(false,secondTry.deleteItem(4));
        secondTry.productAdd("milk",1514752,405.39);
        secondTry.productAdd("2mik",1514757,405.39);
        secondTry.productAdd("ilk",1574752,405.39);
        assertEquals(true,secondTry.deleteItem(1));
    }

    @Test
    void testScan(){
        Major testClass=new Major();
        testClass.productAdd("milk",1514752,405.39);
        testClass.productAdd("potato",1514721,45.39);
        testClass.productAdd("Avokado",15141,4345.39);
        testClass.productAdd("banan",154721,41.39);
        assertEquals(405.39,testClass.scanPriceByName("milk"));
        double a=41.39*9;
        assertEquals(a,testClass.searchPriceByCode(154721,9));
        assertEquals("avokado",testClass.searchNameByCode(15141));
        assertEquals(45.39,testClass.scanPriceByName("Potato"));
    }


}
