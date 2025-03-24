package com.dao;

import com.entities.CategoryMaster;
import com.helper.FactoryProvider;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class CategoryDao {

	public String saveCategory(CategoryMaster category) {
	    Transaction transaction = null;
	    try (Session session = FactoryProvider.getFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(category);
	        transaction.commit();
	        return "success";
	    } catch (ConstraintViolationException e) { 
	        if (transaction != null) transaction.rollback();
	        return "Category Code already exists! Please use a different code.";
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	        return "Category Code already exists! Please use a different code.S";
	    }
	}


    public List<CategoryMaster> getAllCategories() {
        try (Session session = FactoryProvider.getFactory().openSession()) {
            return session.createQuery("FROM CategoryMaster", CategoryMaster.class).list();
        }
    }

    public CategoryMaster getCategoryById(String catCd) {
        try (Session session = FactoryProvider.getFactory().openSession()) {
            return session.get(CategoryMaster.class, catCd);
        }
    }

    public boolean updateCategory(CategoryMaster category) {
        Transaction transaction = null;
        try (Session session = FactoryProvider.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public void deleteCategory(String catCd) {
        Transaction transaction = null;
        try (Session session = FactoryProvider.getFactory().openSession()) {
            transaction = session.beginTransaction();
            CategoryMaster category = session.get(CategoryMaster.class, catCd);
            if (category != null) {
                session.delete(category);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
