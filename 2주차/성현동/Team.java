package hellojpa;

import jakarta.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;…
}