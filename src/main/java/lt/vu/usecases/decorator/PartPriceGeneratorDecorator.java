package lt.vu.usecases.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class PartPriceGeneratorDecorator implements IPartPriceGenerator {

    @Inject
    @Delegate
    @Any
    IPartPriceGenerator iPartPriceGenerator;

    @Override
    public Integer generatePartPrice(){
        try{
            Integer generatedPrice = iPartPriceGenerator.generatePartPrice();
            Thread.sleep(6000);
            System.out.println("Decorator DONE");
            return generatedPrice;
        }catch (InterruptedException e){
            return 0;
        }

    }

}
