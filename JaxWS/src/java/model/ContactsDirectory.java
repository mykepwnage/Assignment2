/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mpwnage12
 */
@XmlRootElement
public class ContactsDirectory {

    @XmlElementWrapper(name = "Contacts")
    List<Contact> contactsDirectory = new ArrayList<Contact>();

    public int getSize() {
        return contactsDirectory.size();

    }

    public void addContact(Contact contact) {
        contactsDirectory.add(contact);
    }

    public void deleteContact(int id) {
        contactsDirectory.remove(id);
    }

    public void setContactsDirectory(List<Contact> contactsDirectory) {
        this.contactsDirectory = contactsDirectory;
    }

    public List<Contact> getAllTheContacts() {
        return contactsDirectory;
    }
}
