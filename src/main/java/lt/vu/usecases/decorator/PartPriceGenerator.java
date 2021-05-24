package lt.vu.usecases.decorator;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class PartPriceGenerator implements Serializable, IPartPriceGenerator {

    public Integer generatePartPrice(){
        try{
            Thread.sleep(3000);
            System.out.println("THREAD SLEEP DONE");
        }catch (InterruptedException e) {

        }
        Integer randomNumber = new Random().nextInt(2000);
        return randomNumber;
    }
}
