package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Computer;
import lt.vu.entities.Part;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.ComputerDAO;
import lt.vu.persistence.PartsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class PcBuildParts implements Serializable {

    @Inject
    private ComputerDAO computerDAO;

    @Inject
    private PartsDAO partsDAO;

    @Getter @Setter
    private Computer computer;

    @Getter @Setter
    private Part partToCreate = new Part();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int computerId = Integer.parseInt(requestParameters.get("computerId"));
        this.computer = computerDAO.findOne(computerId);
    }

    @Transactional
    @LoggedInvocation
    public String createPart() {
        List<Computer> computers = new ArrayList<>();
        computers.add(this.computer);
        partToCreate.setComputers(computers);
        partsDAO.persist(this.partToCreate);
        return "parts?faces-redirect=true&computerId=" + this.computer.getId();
    }

}
