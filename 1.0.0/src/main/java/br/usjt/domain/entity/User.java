package br.usjt.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.usjt.domain.contracts.Hash;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Avaliation> avaliations;

    public boolean authenticate(String password, Hash hashDriver) {
        return hashDriver.compare(this.password, password);
    }

    public static User fromRaw(String name, String email, String password) {
        User user = new User();
        user.name = name;
        user.password = password;
        user.email = email;
        return user;
    }
}
