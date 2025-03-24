package com.dao;



import com.entities.ShiftMaster;
import com.helper.FactoryProvider;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ShiftDao {

	public String saveShift(ShiftMaster shift) {
	    Transaction transaction = null;
	   
	    
	    try (Session session = FactoryProvider.getFactory().openSession()) {
	        //Check if the shift code already exists
	        ShiftMaster existingShift = session.get(ShiftMaster.class, shift.getShiftCd());
	        if (existingShift != null) {
	            return "Shift Code already exists! Please use a different code.";
	        }

	        transaction = session.beginTransaction();
	        session.save(shift);
	        transaction.commit();
	        return "success";
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	        return "An error occurred while saving the shift.";
	    }
	}


    public List<ShiftMaster> getAllShifts() {
        try (Session session = FactoryProvider.getFactory().openSession()) {
            return session.createQuery("FROM ShiftMaster", ShiftMaster.class).list();
        }
    }

    public ShiftMaster getShiftById(String shiftCd) {
        try (Session session = FactoryProvider.getFactory().openSession()) {
            return session.get(ShiftMaster.class, shiftCd);
        }
    }

    public boolean updateShift(ShiftMaster shift) {
        Transaction transaction = null;
        try (Session session = FactoryProvider.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(shift);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public void deleteShift(String shiftCd) {
        Transaction transaction = null;
        try (Session session = FactoryProvider.getFactory().openSession()) {
            transaction = session.beginTransaction();
            ShiftMaster shift = session.get(ShiftMaster.class, shiftCd);
            if (shift != null) {
                session.delete(shift);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
