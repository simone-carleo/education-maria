package it.adt.comparison.dao.entity;

import it.adt.comparison.dao.AbstractTimestampAndVersionEntity;

import javax.persistence.*;

@Entity
@Table(name = "od_estimation")
public class OdEstimationEntity extends AbstractTimestampAndVersionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "o", nullable = false)
    private int o;
    @Column(name = "d", nullable = false)
    private int d;
    @Column(name = "classe", nullable = false)
    private int classe;
    @Column(name = "ts", nullable = false)
    private int ts;
    @Column(name = "val", nullable = true)
    private double val;

    public OdEstimationEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}
