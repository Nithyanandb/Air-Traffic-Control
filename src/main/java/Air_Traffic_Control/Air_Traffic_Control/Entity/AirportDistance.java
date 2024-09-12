package Air_Traffic_Control.Air_Traffic_Control.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@IdClass(AirportDistanceId.class)
public class AirportDistance {

    @Id
    private Long airportId1;

    @Id
    private Long airportId2;

    private int distance;

    public AirportDistance(AirportDistanceId id, int distance) {
        this.airportId1 = id.getAirportId1();
        this.airportId2 = id.getAirportId2();
        this.distance = distance;
    }
}
