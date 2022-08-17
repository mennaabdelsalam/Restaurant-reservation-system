package xml;


import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Usersxml {

    @XmlElement(name = "user")
    private List<Userxml> use;

    public List<Userxml> getUsersList() {
        return use;
    }

    public void setUsers(List<Userxml> users) {
        this.use = users;
    }

}

