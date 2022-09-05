package edu.hanoi.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "HN_GROUP", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

}
