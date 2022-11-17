package edu.upc.dsa;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.upc.dsa.Domain.Covid19Manager;
import edu.upc.dsa.Domain.Entity.Exceptions.LabYaExiste;
import edu.upc.dsa.Domain.Entity.Exceptions.PersonaYaExiste;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Covid19ManagerImpl {

    Covid19Manager manager;

    @Before
    public void setUp() throws PersonaYaExiste, LabYaExiste {
        this.manager = new edu.upc.dsa.Infraestructure.Covid19ManagerImpl();

        this.manager.añadirPersona("432746","Itziar","Mensa",20,"A");
        this.manager.añadirPersona("3728865","Paula","Mensa",19,"B");
        this.manager.añadirPersona("378238346","Monica","Minguito",49,"C");
        this.manager.añadirPersona("3618235","Sara","Jimenez",36,"D");

        this.manager.crearLab("4327873","Vall d'Hebron");
        this.manager.crearLab("4327","Clínic");
        this.manager.crearLab("54738","Hospital Igualada");
        this.manager.crearLab("546326","Sant Joan de Déu");

    }

    @After
    public void tearDown() {
        this.manager = null;
    }

    @Test
    public void testAñadirPersona(){
        Assert.assertEquals(4,this.manager.numPersonas());
        Assert.assertEquals(4,this.manager.numLabs());
    }

}
