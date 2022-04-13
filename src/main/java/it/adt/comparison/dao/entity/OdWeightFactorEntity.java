package it.adt.comparison.dao.entity;

import it.adt.comparison.dao.AbstractTimestampAndVersionEntity;

import javax.persistence.*;

@Entity
@Table(name = "od_weight_factor")
public class OdWeightFactorEntity extends AbstractTimestampAndVersionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "p", nullable = false)
    private double p;

    public OdWeightFactorEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }
}
