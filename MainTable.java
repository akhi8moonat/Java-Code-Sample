/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Akhilesh
 */
@Entity
public class MainTable
{
        @Id
        private int BusId;
        private int DriverId;
        private int DriverContact;
        private String Route;

    public int getBusId() {
        return BusId;
    }

    public int getDriverId() {
        return DriverId;
    }

    public int getDriverContact() {
        return DriverContact;
    }

    public String getRoute() {
        return Route;
    }

    public void setBusId(int BusId) {
        this.BusId = BusId;
    }

    public void setDriverId(int DriverId) {
        this.DriverId = DriverId;
    }

    public void setDriverContact(int DriverContact) {
        this.DriverContact = DriverContact;
    }

    public void setRoute(String Route) {
        this.Route = Route;
    }
      
}
