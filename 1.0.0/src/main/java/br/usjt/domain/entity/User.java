package br.usjt.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.usjt.domain.contracts.Hash;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Avaliation> avaliations;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean authenticate(String password, Hash hashDriver) {
        return hashDriver.compare(this.password, password);
    }
}
