package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.CompanyMaster;
import com.helper.FactoryProvider;

import java.util.List;

public class CompanyDao {
	public List<CompanyMaster> getAllCompanies() {
		try (Session session = FactoryProvider.getFactory().openSession()) {
			return session.createQuery("FROM CompanyMaster", CompanyMaster.class).list();
		}
	}

	public CompanyMaster getCompanyByCode(String compCode) {
		try (Session session = FactoryProvider.getFactory().openSession()) {
			return session.get(CompanyMaster.class, compCode);
		}
	}

	public boolean updateCompany(CompanyMaster company) {
		Transaction tx = null;
		boolean updated = false;
		Session session = FactoryProvider.getFactory().openSession();

		try {
			tx = session.beginTransaction();

			// Check if the GSTIN already exists (excluding the current company being
			// updated)
			Query<CompanyMaster> query = session.createQuery(
					"FROM CompanyMaster WHERE gstin = :gstin AND compCode != :compCode", CompanyMaster.class);
			query.setParameter("gstin", company.getGstin());
			query.setParameter("compCode", company.getCompCode());

			CompanyMaster existingCompany = query.uniqueResultOptional().orElse(null);

			if (existingCompany != null) {
				// GSTIN already exists
				System.out.println("Company with this GSTIN already exists.");
				return false;
			}

			// Proceed with update since GSTIN is unique
			session.update(company);
			tx.commit();
			updated = true;
		} catch (Exception e) {
			if (tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return updated; // Return true if update was successful
	}

	public void deleteCompany(String compCode) {
		try (Session session = FactoryProvider.getFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			CompanyMaster company = session.get(CompanyMaster.class, compCode);
			if (company != null) {
				session.delete(company);
			}
			tx.commit();
		}
	}

	public String addCompany(CompanyMaster company) {
		Transaction tx = null;
		Session session = FactoryProvider.getFactory().openSession();
		String errorMessage = null; // Store error message

		try {
			tx = session.beginTransaction();

			// Check if GSTIN OR CompCode already exists
			Query<CompanyMaster> query = session.createQuery(
					"FROM CompanyMaster WHERE gstin = :gstin OR compCode = :compCode", CompanyMaster.class);
			query.setParameter("gstin", company.getGstin());
			query.setParameter("compCode", company.getCompCode());

			CompanyMaster existingCompany = query.uniqueResultOptional().orElse(null);

			if (existingCompany != null) {
				if (existingCompany.getGstin().equals(company.getGstin())) {
					errorMessage = "Company with this GSTIN is already registered!";
				} else if (existingCompany.getCompCode().equals(company.getCompCode())) {
					errorMessage = "Company with this Company Code is already registered!";
				}
				return errorMessage; // Return error message instead of false
			}

			// If no duplicate, save the company
			session.save(company);
			tx.commit();

		} catch (Exception e) {
			if (tx != null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
			errorMessage = "Error occurred while saving the company!";
		} finally {
			session.close();
		}

		return errorMessage; 
	}

	public boolean isGstinOrCompCodeRegistered(String gstin, String compCode) {
		try (Session session = FactoryProvider.getFactory().openSession()) {
			Query<CompanyMaster> query = session.createQuery(
					"FROM CompanyMaster WHERE gstin = :gstin OR compCode = :compCode", CompanyMaster.class);
			query.setParameter("gstin", gstin);
			query.setParameter("compCode", compCode);

			return query.uniqueResultOptional().isPresent();
		} catch (Exception e) {
			e.printStackTrace();
			return false; // Assume it's not registered in case of error
		}
	}

}