
package se.distansakademin.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import se.distansakademin.models.Project;

import java.util.List;

public class ProjectsRepository {

    private EntityManager entityManager;

    public ProjectsRepository() {
        var emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
    }
    public Project getProjectById(Long id){
        var project = entityManager.find(Project.class, id);
        return project;
    }

    public List<Project> getAll(){
        var query = entityManager.createQuery("SELECT p FROM Project p", Project.class);
        var projects = query.getResultList();
        return projects;
    }

    public void insert(Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
    }

    public void update(Project project) {
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
    }
    public void delete(Long id){
        entityManager.getTransaction().begin();

        var queryString = "DELETE FROM Project WHERE id=:id";
        var query = entityManager.createQuery(queryString);

        query.setParameter("id", id);

        query.executeUpdate();

        entityManager.getTransaction().commit();
    }
}