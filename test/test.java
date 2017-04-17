import org.junit.jupiter.api.Test;


import Products.ListProduct;

import static org.junit.jupiter.api.Assertions.*;


public class test {
    @Test
    void testAdd(){
    ListProduct firstTry=new ListProduct();
    firstTry.productAdd("milk",1514752,405.39);
    assertEquals(false,firstTry.productAdd("milk",1514752,405.39));
    assertEquals(false,firstTry.productAdd("yte",1514752,5751.0));
    assertEquals(false,firstTry.productAdd("@asdh!",11111,233.99));
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
        assertFalse(secondTry.searchInListForCode(1514752));
    }


    @Test
    void  testScan(){
        ListProduct testClass=new ListProduct();
        testClass.productAdd("milk",1514752,405.39);
        testClass.productAdd("potato",1514721,45.39);
        testClass.productAdd("Avokado",15141,4345.39);
        testClass.productAdd("banan",154721,41.39);
        assertEquals(405.39,testClass.searchCodeByObj(1514752).getPrice().doubleValue());
        double a=41.39*9;
        assertEquals(a,testClass.searchPriceByCode(154721,9));
        assertEquals("avokado",testClass.searchCodeByObj(15141).getNameProduct());
    }


    @Test
    void testReplace() {
        ListProduct testClass = new ListProduct();
        testClass.productAdd("milk", 1514752, 405.39);
        testClass.productAdd("potato", 1514721, 45.39);
        testClass.productAdd("Avokado", 15141, 4345.39);
        testClass.productAdd("banan", 154721, 41.39);
        testClass.productAdd("kivi", 384, 700.21);
        testClass.replaceName("milk", "weed");
        assertTrue("weed"==testClass.searchCodeByObj(1514752).getNameProduct());
        try {
            testClass.replaceName("milk", "reer");
        fail("not throw");
        }catch (IllegalArgumentException e){}
        testClass.replacePrice("weed",20.10);
        assertTrue(20.10==testClass.searchPriceByCode(1514752,1));
    }
}
