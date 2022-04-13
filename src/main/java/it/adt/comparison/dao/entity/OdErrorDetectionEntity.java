package it.adt.comparison.dao.entity;

import it.adt.comparison.dao.AbstractTimestampAndVersionEntity;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "od_error_detection")
public class OdErrorDetectionEntity extends AbstractTimestampAndVersionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "timestamp_start", nullable = false)
    private OffsetDateTime timestampStart;

    @Column(name = "timestamp_end", nullable = false)
    private OffsetDateTime timestampEnd;

    @Column(name = "result", nullable = false)
    private boolean result;

    @Column(name = "error", nullable = true)
    private double error;

    public OdErrorDetectionEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OffsetDateTime getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(OffsetDateTime timestampStart) {
        this.timestampStart = timestampStart;
    }

    public OffsetDateTime getTimestampEnd() {
        return timestampEnd;
    }

    public void setTimestampEnd(OffsetDateTime timestampEnd) {
        this.timestampEnd = timestampEnd;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }
}
