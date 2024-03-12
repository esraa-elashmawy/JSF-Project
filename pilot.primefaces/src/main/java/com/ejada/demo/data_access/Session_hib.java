package com.ejada.demo.data_access;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Session_hib {

    private static Session_hib instance;
   // private static SessionFactory sessionFactory;


    private Session_hib() {
        // private constructor to prevent direct instantiation
    }

    public static Session_hib getInstance() {
        if (instance == null) {
            instance = new Session_hib();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
    	 SessionFactory sessionFactory;
    	 
    		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
    				.configure("hibernate.cfg.xml").build();
    		
    		Metadata metaData = new MetadataSources(standardRegistry)
    				.getMetadataBuilder()
    				.build();
    		
    		sessionFactory = metaData.getSessionFactoryBuilder().build();
    	

        return sessionFactory;
    }
    

}
