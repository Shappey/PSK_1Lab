package lt.vu.persistence;

import lt.vu.entities.Computer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@Default
public class ComputerDAO implements IComputerDAO{

    @Inject
    private EntityManager em;

    public List<Computer> getAllComputers() {
        return em.createNamedQuery("Computer.findAll", Computer.class).getResultList();
    }

    public void persist(Computer computer){
        this.em.persist(computer);
    }

    public Computer findOne(Integer id){
        return em.find(Computer.class, id);
    }

    public Computer update(Computer computer){
        return em.merge(computer);
    }

    public void flush() {em.flush();}
}

