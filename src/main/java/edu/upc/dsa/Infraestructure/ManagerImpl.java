package edu.upc.dsa.Infraestructure;

import edu.upc.dsa.Domain.Covid19Manager;
import org.apache.log4j.Logger;

public class ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;

    //protected List<ObjectShop> objects;

    //protected Map<String, User> users;

    final static Logger logger = Logger.getLogger(ManagerImpl.class);

    public ManagerImpl(){
        //this.objects = new ArrayList<>();
        //this.users = new HashMap<>();
    }

    public static Covid19Manager getInstance() {
        if (instance==null) instance = new ManagerImpl();
        return instance;
    }

    public int size() {
        //int size = this.users.size();
        //logger.info("size " + size);
        //return size;
    }

}
