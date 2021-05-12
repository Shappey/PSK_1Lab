package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Component;
import lt.vu.entities.Computer;
import lt.vu.entities.Part;
import lt.vu.persistence.ComponentDAO;
import lt.vu.persistence.ComputerDAO;
import lt.vu.persistence.PartsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class PartsWithComponents {

    @Inject
    private PartsDAO partsDAO;

    @Inject
    private ComponentDAO componentDAO;

    @Inject
    private ComputerDAO computerDAO;

    @Getter
    private Part part;

    @Getter @Setter
    private Component componentToCreate = new Component();

    @Getter @Setter
    private Integer computerIdToAssign = 0;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int partId = Integer.parseInt(requestParameters.get("partId"));
        this.part = partsDAO.findOne(partId);
    }

    @Transactional
    public String createComponent() {
        componentToCreate.setPart(part);
        componentDAO.persist(componentToCreate);
        return "partComponents?faces-redirect=true&partId=" + part.getId();
    }

    @Transactional
    public String assignToComponent() {
        List<Computer> computers = part.getComputers();
        Computer computerToAssign = computerDAO.findOne(computerIdToAssign);
        computers.add(computerToAssign);
        part.setComputers(computers);
        return "partComponents?faces-redirect=true&partId=" + part.getId();
    }


}
