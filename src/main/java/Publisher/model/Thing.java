package Publisher.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Thing {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String data;

    public Thing()
    {}

    public Thing(String name)
    {
        super();
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + data;
    }
}
