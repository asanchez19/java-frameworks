package ac.cr.una.springintro.consumer;

import ac.cr.una.springintro.service.MessageService;

/**
 * A simple application class consuming the service. For XML based configuration, we can use implement either constructor-based spring dependency injection or method-based spring dependency injection.
 * Note that method-based and setter-based injection approaches are same, it’s just that some prefer calling it setter-based and some call it method-based.
 *
 * @author mguzmana
 */
public class MyXMLApplication {

    private MessageService serviceXML;

    //constructor-based dependency injection
    public MyXMLApplication(MessageService svc) {
        this.serviceXML = svc;
    }

    public MessageService getServiceXML() {
        return serviceXML;
    }

    //setter-based dependency injection
    public void setServiceXML(MessageService serviceXML) {
        this.serviceXML = serviceXML;
    }

    public boolean processMessage(String msg, String rec) {
        // some magic like validation, logging etc
        return this.serviceXML.sendMessage(msg, rec);
    }
}
