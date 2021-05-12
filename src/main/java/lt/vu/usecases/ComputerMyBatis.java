package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.model.Computer;
import lt.vu.mybatis.dao.ComputerMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ComputerMyBatis {

    @Inject
    private ComputerMapper computerMapper;

    @Getter
    private List<Computer> allComputers;

    @Getter @Setter
    private Computer computerToCreate = new Computer();

    @PostConstruct
    public void init(){
        this.loadAllComputers();
    }

    @Transactional
    public String createComputer() {
        computerMapper.insert(computerToCreate);
        return "computers?faces-redirect=true";
    }

    private void loadAllComputers() {
        this.allComputers = computerMapper.selectAll();
    }
}
