package lt.vu.usecases.decorator;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class PartCreator implements Serializable, IPartCreator {

    public Integer createPart(){
        try{
            Thread.sleep(3000);
            System.out.println("THREAD SLEEP DONE");
        }catch (InterruptedException e) {

        }
        return 1;
    }
}
