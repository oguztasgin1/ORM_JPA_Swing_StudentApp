package com.oguztasgin.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oguztasgin.entity.Student;
import com.oguztasgin.utils.HibernateUtil;

public class StudentRepository {
	public List<Student> getAll() throws Exception {
		Transaction transaction = null;
		List<Student> list = null;

		try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			list = session.createQuery("FROM Student", Student.class).list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("Kayit basarisiz");
		}
		return list;

	}

	public void save(Student student) throws Exception {
		Transaction transaction = null;

		try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(student);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("Kayit basarisiz");
		}

	}

	public void update(Student student) throws Exception {
		Transaction transaction = null;

		try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.update(student);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("Kayit basarisiz");
		}
	}

	public void delete(int id) throws Exception {
		Transaction transaction = null;
		Student studentTemp = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			studentTemp = session.get(Student.class, id);

			session.delete(studentTemp);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("kayıt başarısız!");
		}
	}

	public List<Student> getByName(String name) throws Exception {
		Transaction transaction = null;
		List<Student> list = null;

		try (Session session = new HibernateUtil().getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			list = session
					.createQuery("SELECT student FROM Student as student WHERE student.firstName =  '" + name + "'",
							Student.class)
					.list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("Kayit basarisiz");
		}
		return list;
	}

	public List<Student> getByLastName(String lastname) throws Exception {
		Transaction transaction = null;
		List<Student> list = null;

		try (Session session = new HibernateUtil().getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			list = session
					.createQuery("SELECT student FROM Student as student WHERE student.lastName =  '" + lastname + "'",
							Student.class)
					.list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("Kayit basarisiz");
		}
		return list;
	}

	public List<Student> getByEmail(String email) throws Exception {
		Transaction transaction = null;
		List<Student> list = null;

		try (Session session = new HibernateUtil().getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			list = session
					.createQuery("SELECT student FROM Student as student WHERE student.email =  '" + email + "'",
							Student.class)
					.list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("Kayit basarisiz");
		}
		return list;
	}
	
	public Student getById(int id) throws Exception {
		Transaction transaction = null;
		Student student = null;
		
		try (Session session = new HibernateUtil().getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			student = session.get(Student.class, id);
			
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("Kayit basarisiz");
		}
		
		return student;	
	}
}
