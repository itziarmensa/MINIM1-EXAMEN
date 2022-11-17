package edu.upc.dsa;

import edu.upc.dsa.Domain.Manager;
import edu.upc.dsa.Infraestructure.ManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagerImplTest {

    Manager manager;

    @Before
    public void setUp(){
        this.manager = new ManagerImpl();

        //this.manager.registerUser("Alba", "Roma Gómez", "23/11/2001", credentials1);
        // ...

        //this.manager.addObject("Pa Bimbo", "un pa molt bo", 2.3);
        // ...

    }

    @After
    public void tearDown() {
        this.manager = null;
    }

    @Test
    //public void ...

}
