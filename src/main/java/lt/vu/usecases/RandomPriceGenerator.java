package lt.vu.usecases;

import lt.vu.usecases.decorator.PartPriceGenerator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class ButtonCooldown implements Serializable {

    @Inject
    private PartPriceGenerator partPriceGenerator;

    private CompletableFuture<Integer> partCreatorTask = null;

    public void startWork() {
        partCreatorTask = CompletableFuture.supplyAsync(()-> partPriceGenerator.generatePartPrice());
    }

    @PostConstruct
    private void printOnCreation(){
        System.out.println("NEW BEAN CREATED TO GENERATE PART PRICE");
    }

    public boolean isPartCreatorRunning() {
        return partCreatorTask != null && !partCreatorTask.isDone();
    }

    public String getPartCreationStatus() throws ExecutionException, InterruptedException {
        if (partCreatorTask == null) {
            return "Add a new part for this Computer";
        } else if (isPartCreatorRunning()) {
            return "Part creation in progress";
        }
        return "Add a new Part for this Computer" + partCreatorTask.get();
    }

    public String generateNewPrice(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        partCreatorTask = CompletableFuture.supplyAsync(()-> partPriceGenerator.generatePartPrice());

        return  "/parts?faces-redirect=true&computerId=" + requestParameters.get("computerId");
    }
}