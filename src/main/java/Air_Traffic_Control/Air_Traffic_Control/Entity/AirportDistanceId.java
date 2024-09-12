package Air_Traffic_Control.Air_Traffic_Control.Entity;

import java.io.Serializable;

public class AirportDistanceId implements Serializable {

    private Long airportId1;
    private Long airportId2;

    public AirportDistanceId() {
    }

    public AirportDistanceId(Long airportId1, Long airportId2) {
        this.airportId1 = airportId1;
        this.airportId2 = airportId2;
    }

    // Getters and Setters
    public Long getAirportId1() {
        return airportId1;
    }

    public void setAirportId1(Long airportId1) {
        this.airportId1 = airportId1;
    }

    public Long getAirportId2() {
        return airportId2;
    }

    public void setAirportId2(Long airportId2) {
        this.airportId2 = airportId2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirportDistanceId that = (AirportDistanceId) o;

        if (!airportId1.equals(that.airportId1)) return false;
        return airportId2.equals(that.airportId2);
    }

    @Override
    public int hashCode() {
        int result = airportId1.hashCode();
        result = 31 * result + airportId2.hashCode();
        return result;
    }
}
