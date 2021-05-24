package lt.vu.persistence;

import lt.vu.entities.Computer;

import java.util.List;

public interface IComputerDAO {

    List<Computer> getAllComputers();

    void persist(Computer computer);

    Computer findOne(Integer id);

    Computer update(Computer computer);
}