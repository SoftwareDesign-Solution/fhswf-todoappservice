package de.fhswf.todoappservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany
    @JoinColumn(name = "status")
    private List<Task> tasks;

    public Status() {}

    public Status(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Status))
            return false;
        Status other = (Status) o;
        boolean idEquals = (this.getId() == null && other.getId() == null)
                || (this.getId() != null && this.getId().equals(other.getId()));
        boolean nameEquals = (this.getName() == null && other.getName() == null)
                || (this.getName() != null && this.getName().equals(other.getName()));
        return idEquals && nameEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (id != null) {
            result = 31 * result + id.hashCode();
        }
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        return result;
    }

}
