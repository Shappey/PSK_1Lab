package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.ComputerMapper;
import lt.vu.mybatis.dao.PartComputerMapper;
import lt.vu.mybatis.dao.PartMapper;
import lt.vu.mybatis.model.Computer;
import lt.vu.mybatis.model.Part;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Model
public class PcBuildPartsMyBatis {

    @Inject
    private ComputerMapper computerMapper;

    @Inject
    private PartMapper partMapper;

    @Inject
    private PartComputerMapper partComputerMapper1;

    @Getter
    @Setter
    private Computer computer;

    @Getter
    @Setter
    private Part partToCreate = new Part();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int computerId = Integer.parseInt(requestParameters.get("computerId"));
        this.computer = computerMapper.selectByPrimaryKey(computerId);
    }

    @Transactional
    public String createPart() {
        List<Computer> computers = new ArrayList<>();
        computers.add(this.computer);
        //this.partToCreate.setComputers((computers));
        partMapper.insert(this.partToCreate);
        return "/myBatis/part?faces-redirect=true&computerId=" + this.computer.getId();
    }



}
