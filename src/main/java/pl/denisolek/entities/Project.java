package pl.denisolek.entities;


import javax.persistence.*;

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
}
