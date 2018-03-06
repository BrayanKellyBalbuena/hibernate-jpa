package edu.itla.hibernatejpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_EMPLOYEE")
    private long id;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRHTDATE")
    private LocalDate birthDate;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_DIRECTION")
    private Direction direction;

    public Employee(){

    }

    public Employee(long id, String lastName, String name, LocalDate birthDate, Direction direcction) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.birthDate = birthDate;
        direcction.setEmployee(this);
        this.setDirecction(direcction);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Direction getDirecction() {
        return direction;
    }

    public void setDirecction(Direction direcction) {
        direcction.setEmployee(this);
        this.direction = direcction;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", direcction=" + direction +
                '}';
    }
}
