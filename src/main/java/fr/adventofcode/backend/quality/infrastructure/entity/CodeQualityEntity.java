package fr.adventofcode.backend.quality.infrastructure.entity;

import fr.adventofcode.backend.quality.domain.Status;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "code_quality")
public class CodeQualityEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String idCodeQuality;

    @ElementCollection
    @Column(length = 10000)
    private List<String> errors;

    private LocalDateTime date;

    private int gain;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private String userResponseId;

    public CodeQualityEntity(){}

    public CodeQualityEntity(String idCodeQuality, List<String> errors, LocalDateTime date, int gain, Status status, String userResponseId) {
        this.idCodeQuality = idCodeQuality;
        this.errors = errors;
        this.date = date;
        this.gain = gain;
        this.status = status;
        this.userResponseId = userResponseId;
    }

    public String getIdCodeQuality() {
        return idCodeQuality;
    }

    public void setIdCodeQuality(String idCodeQuality) {
        this.idCodeQuality = idCodeQuality;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUserResponseId() {
        return userResponseId;
    }

    public void setUserResponseId(String userResponseId) {
        this.userResponseId = userResponseId;
    }
}
