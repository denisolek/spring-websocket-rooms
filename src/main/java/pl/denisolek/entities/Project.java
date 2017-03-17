package pl.denisolek.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Column(name = "client_company")
    private String clientsCompany;

    @Column(name = "executive_company")
    private String executiveCompany;

    @Column(name = "room_name")
    private String roomName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    private Set<User> users = new HashSet<User>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientsCompany() {
        return clientsCompany;
    }

    public void setClientsCompany(String clientsCompany) {
        this.clientsCompany = clientsCompany;
    }

    public String getExecutiveCompany() {
        return executiveCompany;
    }

    public void setExecutiveCompany(String executiveCompany) {
        this.executiveCompany = executiveCompany;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
