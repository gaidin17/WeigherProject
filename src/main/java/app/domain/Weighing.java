package app.domain;

import java.util.Date;

/**
 * Created by Gaidin on 12.11.2017.
 */
public class Weighing {
    private long id;
    private Organization organization;
    private Driver driver;
    private Cargo cargo;
    private Double firstWeighing;
    private Date firstWeighingDate;
    private Double secondWeighing;
    private Date secondWeighingDate;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Double getFirstWeighing() {
        return firstWeighing;
    }

    public void setFirstWeighing(Double firstWeighing) {
        this.firstWeighing = firstWeighing;
    }

    public Date getFirstWeighingDate() {
        return firstWeighingDate;
    }

    public void setFirstWeighingDate(Date firstWeighingDate) {
        this.firstWeighingDate = firstWeighingDate;
    }

    public Double getSecondWeighing() {
        return secondWeighing;
    }

    public void setSecondWeighing(Double secondWeighing) {
        this.secondWeighing = secondWeighing;
    }

    public Date getSecondWeighingDate() {
        return secondWeighingDate;
    }

    public void setSecondWeighingDate(Date secondWeighingDate) {
        this.secondWeighingDate = secondWeighingDate;
    }
}