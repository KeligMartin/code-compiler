package fr.adventofcode.backend.level.infrastructure.entity;

import fr.adventofcode.backend.statement.infrastructure.entity.StatementEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = " level")

public class LevelEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column
    private String name;

    @Column
    private Date createdAt;

    @Column
    private int gain;

    @OneToMany(
            mappedBy = "level",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<StatementEntity> statementEntities = new ArrayList<>();


    public LevelEntity(String id, String name, Date createdAt, int gain) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.gain = gain;
    }

    public LevelEntity() { }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public int getGain() { return gain; }

    public void setGain(int gain) { this.gain = gain; }
}
