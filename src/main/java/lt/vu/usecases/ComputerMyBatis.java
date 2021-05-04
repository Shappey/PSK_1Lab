package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.model.Computer;
import lt.vu.mybatis.dao.ComputerMapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ComputerMyBatis {

    @Inject
    private ComputerMapper computersDao;

    @Resource
    private TransactionSynchronizationRegistry tx;

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
        System.out.println("Pirmas PC TX: " + tx.getTransactionKey());
        this.computersDao.insert(computerToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllComputers() {
        this.allComputers = computersDao.selectAll();
    }
}
