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
public class RandomPriceGenerator implements Serializable {

    @Inject
    private PartPriceGenerator partPriceGenerator;

    private CompletableFuture<Integer> priceGenerationTask = null;

    public void startWork() {
        priceGenerationTask = CompletableFuture.supplyAsync(()-> partPriceGenerator.generatePartPrice());
    }

    @PostConstruct
    private void printOnCreation(){
        System.out.println("NEW BEAN CREATED TO GENERATE PART PRICE");
    }

    public boolean isPriceGeneratorRunning() {
        return priceGenerationTask != null && !priceGenerationTask.isDone();
    }

    public String getPartCreationStatus() throws ExecutionException, InterruptedException {
        if (priceGenerationTask == null) {
            return "Generate a new price: ";
        } else if (isPriceGeneratorRunning()) {
            return "Price is being generated! ";
        }
        return "Generated price is: " + priceGenerationTask.get();
    }

    public String generateNewPrice(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        priceGenerationTask = CompletableFuture.supplyAsync(()-> partPriceGenerator.generatePartPrice());

        return  "/parts?faces-redirect=true&computerId=" + requestParameters.get("computerId");
    }
}