package se.distansakademin.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import se.distansakademin.models.Person;

import java.util.List;

public class PersonsRepository {

    private EntityManager entityManager;
    public PersonsRepository() {
        var emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
    }

    public Person getPersonById(Long id){
        var person = entityManager.find(Person.class, id);
        return person;
    }

    public List<Person> getAllPersons(){
        var query = entityManager.createQuery("SELECT f FROM Person f", Person.class);
        var persons = query.getResultList();
        return persons;
    }

    public void insert(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

    public void update(Person person){
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id){
        entityManager.getTransaction().begin();

        var queryString = "DELETE FROM Person WHERE id=:id";
        var query = entityManager.createQuery(queryString);

        query.setParameter("id", id);

        query.executeUpdate();

        entityManager.getTransaction().commit();
    }

}