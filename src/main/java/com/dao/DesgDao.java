package com.dao;

import com.entities.DesgMaster;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class DesgDao {

	public String saveDesignation(DesgMaster designation) {
	    Transaction transaction = null;
	    try (Session session = FactoryProvider.getFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(designation);
	        transaction.commit();
	        return "success";
	    } catch (ConstraintViolationException e) { 
	        if (transaction != null) transaction.rollback();
	        return "Designation Code already exists! Please use a different code.";
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	        return "Designation Code already exists! Please use a different code.";
	    }
	}


	public List<DesgMaster> getAllDesignations() {
		try (Session session = FactoryProvider.getFactory().openSession()) {
			return session.createQuery("FROM DesgMaster", DesgMaster.class).list();
		}
	}

	public DesgMaster getDesignationById(String desgCd) {
		try (Session session = FactoryProvider.getFactory().openSession()) {
			return session.get(DesgMaster.class, desgCd);
		}
	}

	public boolean updateDesignation(DesgMaster designation) {
		Transaction transaction = null;
		try (Session session = FactoryProvider.getFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(designation);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public void deleteDesignation(String desgCd) {
		Transaction transaction = null;
		try (Session session = FactoryProvider.getFactory().openSession()) {
			transaction = session.beginTransaction();
			DesgMaster designation = session.get(DesgMaster.class, desgCd);
			if (designation != null) {
				session.delete(designation);
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}

	}

}
