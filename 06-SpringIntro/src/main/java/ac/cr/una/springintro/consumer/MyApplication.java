package ac.cr.una.springintro.consumer;


import ac.cr.una.springintro.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Component annotation is added to the class, so that when Spring framework will scan for the components, this class will be treated as component.
 * @Component annotation can be applied only to the class and it’s retention policy is Runtime. If you are not not familiar with Annotations retention policy,
 * I would suggest you to read java annotations tutorial.
 * @Autowired annotation is used to let Spring know that autowiring is required. This can be applied to field, constructor and methods.
 * This annotation allows us to implement constructor-based, field-based or method-based dependency injection in our components.
 * For our example, I am using method-based dependency injection. You can uncomment the constructor method to switch to constructor based dependency injection.
 *
 * @author mguzmana
 */

@Component
public class MyApplication {

    // field-based dependency injection
    // @Autowired
    private MessageService service;

    // constructor-based dependency injection
    //@Autowired
    public MyApplication(MessageService svc){
        this.service=svc;
    }

    public MessageService getService() {
        return service;
    }

    @Autowired
    public void setService(MessageService service) {
        this.service = service;
    }

    public boolean processMessage(String msg, String rec){
        //some magic like validation, logging etc
        return this.service.sendMessage(msg, rec);
    }
}
