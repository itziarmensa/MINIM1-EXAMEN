package edu.upc.dsa.Infraestructure;

import edu.upc.dsa.Domain.Manager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private static Manager instance;

    //protected List<ObjectShop> objects;

    //protected Map<String, User> users;

    final static Logger logger = Logger.getLogger(ManagerImpl.class);

    public ManagerImpl(){
        //this.objects = new ArrayList<>();
        //this.users = new HashMap<>();
    }

    public static Manager getInstance() {
        if (instance==null) instance = new ManagerImpl();
        return instance;
    }

    public int size() {
        //int size = this.users.size();
        //logger.info("size " + size);
        //return size;
    }

}
