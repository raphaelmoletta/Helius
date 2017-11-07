package br.edu.utfpr.dainf.eex23.helius.beans;

import com.google.gson.Gson;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raphael Zagonel Moletta <raphael.moletta@gmail.com>
 */
public class DataTest {
    
    public DataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStatus method, of class Data.
     */
    @Test
    public void testGetStatus() {
        System.out.println("========= getStatus =========");
        Data data = new Data();
        data.setId("1");
        data.setStatus(Data.STATUS.empty);
        ArrayList<Eletrical> eletrical = new ArrayList<>();
        ArrayList<Wheather> wheather = new ArrayList<>();
        eletrical.add(new Eletrical("Painel", 1.51, 2.34));
        wheather.add(new Wheather("Sensores 1", 3.49, 4.11));
        data.setEletrical(eletrical);
        data.setWheater(wheather);
        Data instance = new Data();
        Gson g = new Gson();
        System.out.println(g.toJson(data, Data.class));
        System.out.println("# create empty");
        System.out.println(g.toJson(instance, Data.class));
        assertEquals(Data.STATUS.empty, instance.getStatus());
        System.out.println("#create status error");
        instance = new Data(Data.STATUS.error);
        assertEquals(Data.STATUS.error, instance.getStatus());
    }

    /**
     * Test of setStatus method, of class Data.
     
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Data.STATUS status = null;
        Data instance = new Data();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Data.
     
    @Test
    public void testGetId() {
        System.out.println("getId");
        Data instance = new Data();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Data.
     
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        Data instance = new Data();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEletrical method, of class Data.
     
    @Test
    public void testGetEletrical() {
        System.out.println("getEletrical");
        Data instance = new Data();
        List<Eletrical> expResult = null;
        List<Eletrical> result = instance.getEletrical();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEletrical method, of class Data.
     
    @Test
    public void testSetEletrical() {
        System.out.println("setEletrical");
        List<Eletrical> eletrical = null;
        Data instance = new Data();
        instance.setEletrical(eletrical);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWheater method, of class Data.
     
    @Test
    public void testGetWheater() {
        System.out.println("getWheater");
        Data instance = new Data();
        List<Wheather> expResult = null;
        List<Wheather> result = instance.getWheater();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWheater method, of class Data.
     
    @Test
    public void testSetWheater() {
        System.out.println("setWheater");
        List<Wheather> wheater = null;
        Data instance = new Data();
        instance.setWheater(wheater);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
