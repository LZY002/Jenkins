package entities;

import javax.ejb.Stateless;

@Stateless
public class Client {

    String name;
    int satisfaction;
    int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public int getId() {
        return id;
    }
}
