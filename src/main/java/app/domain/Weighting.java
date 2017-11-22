package app.domain;

import java.util.Date;

/**
 * Created by Gaidin on 12.11.2017.
 */
public class Weighting {
    private long id;
    private Organization organization;
    private Driver driver;
    private Truck truck;
    private Cargo cargo;
    private Double firstweighting;
    private Date firstweightingDate;
    private Double secondweighting;
    private Date secondweightingDate;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
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

    public Double getFirstweighting() {
        return firstweighting;
    }

    public void setFirstweighting(Double firstweighting) {
        this.firstweighting = firstweighting;
    }

    public Date getFirstweightingDate() {
        return firstweightingDate;
    }

    public void setFirstweightingDate(Date firstweightingDate) {
        this.firstweightingDate = firstweightingDate;
    }

    public Double getSecondweighting() {
        return secondweighting;
    }

    public void setSecondweighting(Double secondweighting) {
        this.secondweighting = secondweighting;
    }

    public Date getSecondweightingDate() {
        return secondweightingDate;
    }

    public void setSecondweightingDate(Date secondweightingDate) {
        this.secondweightingDate = secondweightingDate;
    }
}