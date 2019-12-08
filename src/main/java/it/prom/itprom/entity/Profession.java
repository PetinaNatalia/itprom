package it.prom.itprom.entity;


import javax.persistence.*;

@Entity
@Table(name = "professions")
public class Profession {

    @Column(name = "prof_id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "prof_name")
    private String name;

    @Column(name = "prof_note")
    private String note;

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
}
