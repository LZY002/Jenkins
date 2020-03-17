package entities;

import javax.ejb.Stateless;

@Stateless
public class Drone {
    int id;
    double TimeLeftBeforeCharge;
    double TimeLeftBeforeMaintenance;
    DroneState droneState;

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeLeftBeforeCharge(double timeLeftBeforeCharge) {
        TimeLeftBeforeCharge = timeLeftBeforeCharge;
    }

    public void setTimeLeftBeforeMaintenance(double timeLeftBeforeMaintenance) {
        TimeLeftBeforeMaintenance = timeLeftBeforeMaintenance;
    }

    public void setDroneState(DroneState droneState) {
        this.droneState = droneState;
    }

    public int getId() {
        return id;
    }

    public double getTimeLeftBeforeCharge() {
        return TimeLeftBeforeCharge;
    }

    public double getTimeLeftBeforeMaintenance() {
        return TimeLeftBeforeMaintenance;
    }

    public DroneState getDroneState() {
        return droneState;
    }
}
