package lt.vu.persistence;

import lt.vu.entities.Component;
import lt.vu.interceptors.LoggedInvocation;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
@Specializes
@LoggedInvocation
public class LoggedComponentsDAO extends ComponentDAO{

    @Inject
    private EntityManager em;

    public void persist(Component component){
        System.out.println("Persisting component safely");
        this.em.persist(component);
    }
}
