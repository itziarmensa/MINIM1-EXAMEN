package edu.upc.dsa;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.upc.dsa.Domain.Covid19Manager;
import edu.upc.dsa.Domain.Entity.Exceptions.*;
import edu.upc.dsa.Domain.Entity.Laboratorio;
import edu.upc.dsa.Domain.Entity.Muestra;
import edu.upc.dsa.Domain.Entity.Persona;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Queue;

public class Covid19ManagerImplTest {

    Covid19Manager manager;

    @Before
    public void setUp() throws PersonaYaExiste, LabYaExiste, MuestraYaExiste {
        this.manager = new edu.upc.dsa.Infraestructure.Covid19ManagerImpl();

        this.manager.añadirPersona("432746","Itziar","Mensa",20,"A");
        this.manager.añadirPersona("3728865","Paula","Mensa",19,"B");
        this.manager.añadirPersona("378238346","Monica","Minguito",49,"C");
        this.manager.añadirPersona("3618235","Sara","Jimenez",36,"D");

        this.manager.crearLab("4327873","Vall d'Hebron");
        this.manager.crearLab("4327","Clínic");
        this.manager.crearLab("54738","Hospital Igualada");
        this.manager.crearLab("546326","Sant Joan de Déu");

        this.manager.añadirMuestra("4873934629","4327873","3728865", "17/11/2022","4327");
        this.manager.añadirMuestra("5214","4327","432746", "19/11/2022","546326");


    }

    @After
    public void tearDown() {
        this.manager = null;
    }

    @Test
    public void testListas(){
        List<Persona> personas = this.manager.listPersonas();
        Assert.assertEquals(4,personas.size());
        List<Laboratorio> labs = this.manager.listaLabs();
        Assert.assertEquals(4,labs.size());
        Queue<Muestra> muestras = this.manager.listMuestras();
        Assert.assertEquals(2,muestras.size());
    }

    @Test
    public void testAñadirPersona() throws PersonaYaExiste {
        Assert.assertEquals(4,this.manager.numPersonas());
        this.manager.añadirPersona("75843","Óscar","Boullosa",21,"A");
        Assert.assertEquals(5,this.manager.numPersonas());
    }

    @Test
    public void testCrearLab() throws LabYaExiste {
        Assert.assertEquals(4,this.manager.numLabs());
        this.manager.crearLab("75843","Hospital");
        Assert.assertEquals(5,this.manager.numLabs());
    }

    @Test
    public void testExtraerMuestra() throws PersonaNoExiste, LabNoExiste, MuestraYaExiste {
        Queue<Muestra> lista = this.manager.listMuestras();
        Muestra muestra = lista.poll();
        this.manager.extraerMuestra(muestra);
        List<Laboratorio> labs = this.manager.listaLabs();
        Laboratorio labor = labs.get(1);
        Assert.assertEquals(1,this.manager.numMuestras());
        Assert.assertEquals(muestra, labor.getMuestrasPendientes().poll());
    }

    @Test
    public void testProcesarMuestra() throws MuestraYaExiste, PersonaNoExiste, LabNoExiste {
        Queue<Muestra> lista = this.manager.listMuestras();
        List<Laboratorio> labs = this.manager.listaLabs();
        Laboratorio labo = labs.get(1);
        Muestra muestra = lista.poll();
        this.manager.extraerMuestra(muestra);
        Assert.assertEquals(1,labo.getMuestrasPendientes().size());
        this.manager.procesarMuestra("4327");
        Assert.assertEquals(0,labo.getMuestrasPendientes().size());
        List<Persona> personas = this.manager.listPersonas();

    }

    @Test
    public void testListMuestrasProcesadasUsuario() throws PersonaNoExiste {
        List<Muestra> procesadas = this.manager.listaMuestrasPersonaProcesadas("3728865");
        Assert.assertEquals(0, procesadas.size());
    }

}
