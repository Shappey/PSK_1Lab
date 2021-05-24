package lt.vu.persistence;

import lt.vu.entities.Computer;
import lt.vu.enums.BrandName;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Alternative
public class TestComputersDAO implements IComputerDAO { //CHANGE

    @Override
    public List<Computer> getAllComputers() {
        List<Computer> computers = new ArrayList<>();
        Computer computer = new Computer();
        computer.setName("Test Computer for Alternative method");
        computer.setId(100);
        computer.setBrandName(BrandName.Origin);
        computers.add(computer);
        return computers;
    }

    @Override
    public void persist(Computer computer) {

    }

    @Override
    public Computer findOne(Integer id) {
        if (id == 100) return null;
        Computer computer = new Computer();
        computer.setId(id);
        computer.setName("Test Computer for Alternative method");
        computer.setBrandName(BrandName.Origin);
        return computer;
    }

    @Override
    public Computer update(Computer computer) {
        return computer;
    }
}
