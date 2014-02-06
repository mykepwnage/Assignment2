/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.Contact;
import model.ContactsDirectory;

/**
 *
 * @author mpwnage12
 */
@WebService(serviceName = "JaxWebService")
public class JaxWebService {

    ContactsDirectory contacts = null;

    /**
     * This method creates a contacts directory object
     */
    @WebMethod(operationName = "openContacts")
    public String openContacts() {

        String state = "Already open!";

        if (contacts == null) {
            contacts = new ContactsDirectory();
            state = "Opened";
        }

        return state;
    }

    /**
     * This method deletes a contacts directory object
     */
    @WebMethod(operationName = "closeContacts")
    public String closeContacts() {
        String state = "Already closed!";

        if (contacts != null) {
            contacts = null;
            state = "Closed";
        }

        return state;
    }

    /**
     * This method adds a contact to the contacts directory
     */
    @WebMethod(operationName = "addContact")
    public String addContact(@WebParam(name = "contact") Contact contact) {

        String state;

        try {
            contact.setId(contacts.getSize());
            contacts.addContact(contact);
            state = "Added";
        } catch (Exception e) {
            state = "Not added!\nBecause: " + e;

        }

        return state;
    }

    /**
     * This method gets all the contacts from the contacts directory
     */
    @WebMethod(operationName = "getAllContacts")
    public List<Contact> getAllContacts() {

        List<Contact> toReturn = null;

        if (contacts != null) {

            toReturn = contacts.getAllTheContacts();
        }
        return toReturn;
    }

    /**
     * This method gets all the contacts from the contacts directory
     */
    @WebMethod(operationName = "deleteContact")
    public String deleteContact(int id) {

        String state;
        try {
            contacts.deleteContact(id);
            state = "Deleted";
        } catch (Exception e) {
            state = "Not deleted";
        }

        return state;
    }

////    Milestone  2
//    
//        try {
//        JAXBContext context = JAXBContext.newInstance(ContactsDirectory.class);
//
//        Marshaller m = context.createMarshaller();
//        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//        FIleOutputSTream outputStream = new FileOutputStream("messages.xml");
//
//        marshal(messageBoard, outputStream);
//
//        FileInputStream()
//    }
//    catch (Exception e){
//     
//    }
    
}
