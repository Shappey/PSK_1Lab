package lt.vu.usecases;

import lombok.Setter;
import lombok.Getter;
import lt.vu.entities.Computer;
import lt.vu.persistence.ComputerDAO;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Computers {

    @Inject
    private ComputerDAO computersDao;

    @Getter
    private List<Computer> allComputers;

    @Getter @Setter
    private Computer computerToCreate = new Computer();

    @PostConstruct
    public void init(){
        loadAllComputers();
    }

    @Transactional
    public String createComputer() {
        computersDao.persist(computerToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllComputers() {
        this.allComputers = computersDao.getAllComputers();
    }
}
