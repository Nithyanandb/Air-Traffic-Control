package Air_Traffic_Control.Air_Traffic_Control.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDateTime;

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

    @ManyToOne
    private Plane plane;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private double distance; // Distance in kilometers (or any other unit)
}
