package com.example.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {

    private static JPA instance;

    private static final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("JPA");

    private JPA() {
    }


    public static JPA getInstance() {

                if (instance == null) {
                    instance = new JPA();
                }

        return instance;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();

    }

}

