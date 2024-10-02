package Air_Traffic_Control.Air_Traffic_Control.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Airport origin;

    @ManyToOne
    private Airport destination;

    private double distance;


    public Flight() {}

    public Flight(Airport origin, Airport destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }


}
