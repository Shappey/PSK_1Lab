package lt.vu.persistence;

import lt.vu.entities.Part;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PartsDAO {

    @Inject
    private EntityManager em;

    public void persist(Part part){
        this.em.persist(part);
    }

    public Part findOne(Integer id){
        return em.find(Part.class, id);
    }

    public Part update(Part part){
        return em.merge(part);
    }
}
