package lt.vu.usecases.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class PartCreatorDecorator implements IPartCreator{

    @Inject
    @Delegate
    @Any
    IPartCreator partCreator;

    @Override
    public Integer createPart(){
        System.out.println("we made it 1");
        try{
            partCreator.createPart();
            System.out.println("we made it 2");
            Thread.sleep(7000);
            System.out.println("Decorator DONE");
        }catch (InterruptedException e){

        }
        return 4;
    }

}
