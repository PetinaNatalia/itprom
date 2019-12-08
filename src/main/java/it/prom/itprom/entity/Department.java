package it.prom.itprom.entity;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Column (name = "dep_id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dep_name")
    private String name;

    @Column(name = "dep_note")
    private String note;

    @OneToOne
    @JoinColumn(name = "parant_id", referencedColumnName = "dep_id")
    private Department department;

    public Department() {
    }

    public Department(String name, String note) {
        this.name = name;
        this.note = note;
    }

    //TODO: equels(), hashCode()

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
