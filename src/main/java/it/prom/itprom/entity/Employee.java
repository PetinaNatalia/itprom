package it.prom.itprom.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Column(name = "emp_id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_note")
    private String note;

    @OneToOne
    @JoinColumn(name = "emp_profession", referencedColumnName = "prof_id")
    private Profession profession;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "emp_dep_id", referencedColumnName = "dep_id")
    private Department department;

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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
