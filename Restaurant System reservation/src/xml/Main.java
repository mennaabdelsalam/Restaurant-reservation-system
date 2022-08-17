package xml;

import Inheritance.*;
import org.omg.CORBA.UserException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Main {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jax = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller u = jax.createUnmarshaller();
        Restaurant r = (Restaurant) u.unmarshal(new File("input.xml"));
        //baloop beeh  3ashan ye2ra bas
        //list userxml which is name list is just for reading info from xmlfile
        //creation of list l from user is for inheritance instance from uster to other manger and employee
        List<Userxml> list = r.getUsersObject().getUsersList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "   " + list.get(i).getRole() + "   " + list.get(i).getUsername() + "   " + list.get(i).getPassword());
        }
        List<User> l = new ArrayList<>();
        for (Userxml x : list) {
            if (x.getRole().equals("Manager")) {
                Manager m = new Manager(x.getName(), x.getUsername(), x.getPassword());
                l.add(m);
            }
            if (x.getRole().equals("Waiter")) {
                Waiter w = new Waiter(x.getName(), x.getUsername(), x.getPassword());
                l.add(w);
            }
            if (x.getRole().equals("Client")) {
                Client cl = new Client(x.getName(), x.getUsername(), x.getPassword());
                l.add(cl);
            }
            if (x.getRole().equals("Cooker")) {
                Cooker c = new Cooker(x.getName(), x.getUsername(), x.getPassword());
                l.add(c);
            }
        }
    }
}
