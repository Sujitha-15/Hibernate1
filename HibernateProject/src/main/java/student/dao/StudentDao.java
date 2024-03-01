package student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import student.dto.Student;

public class StudentDao {
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void saveStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	
	public Student updateStudent(int id,Student student) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			student.setId(id);
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		}
		return null;
	}
	
	public Student deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return student;
			
		}
		return null;
	}
	
	public Student getStudentById(int id) {
		EntityManager entityManager=getEntityManager();
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			return student;
		}
		else {
			return null;
		}
	}
}
