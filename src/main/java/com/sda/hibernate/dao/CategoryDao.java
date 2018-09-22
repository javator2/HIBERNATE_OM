package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUnits;
import com.sda.hibernate.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao implements DaoInterface<Category> {

    private Session currentSession;
    private Transaction currentTransaction;

    public CategoryDao(){
        currentSession = HibernateUnits.getSession();
        currentTransaction = currentSession.beginTransaction();
    }

    public Session getCurrentSession(){
        return currentSession;
    }

    public void openCurrentSession(){
        currentSession = HibernateUnits.getSession();
        currentTransaction = currentSession.beginTransaction();

    }

    public void closeCurrentSession(){
        currentTransaction.commit();
        currentSession.close();
    }


    @Override
    public Category save(Category entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void update(Category entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public void delete(Category entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Category> findAll() {
        return null;
    }
}