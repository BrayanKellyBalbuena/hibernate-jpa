package edu.itla.hibernatejpa.model;

import javax.persistence.*;

@Entity
@Table(name = "DIRECTION")
public class Direction {

    @Id
    @Column(name = "ID_DIRECTION")
    private Long id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String Country;

    @OneToOne(mappedBy = "direction", fetch = FetchType.LAZY)
    private Employee employee;

    public Direction(){}

    public Direction(Long id){ this.id = id;}

    public Direction(Long id, String address, String location, String state, String country) {
        this.id = id;
        this.address = address;
        this.location = location;
        this.state = state;
        Country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", state='" + state + '\'' +
                ", Country='" + Country + '\'' +
                ", Employee ID='" +getEmployee().getId() + '\'' +
                 '}';
    }
}
