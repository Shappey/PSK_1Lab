package lt.vu.persistence;

import lt.vu.entities.Component;
import lt.vu.entities.Part;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ComponentDAO {

    @Inject
    private EntityManager em;

    public void persist(Component component){
        this.em.persist(component);
    }

    public Part findOne(Integer id){
        return em.find(Part.class,id);
    }

    public Part update(Part part){
        return em.merge(part);
    }
}
