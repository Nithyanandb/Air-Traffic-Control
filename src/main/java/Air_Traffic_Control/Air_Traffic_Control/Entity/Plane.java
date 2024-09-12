package Air_Traffic_Control.Air_Traffic_Control.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String model;
    private boolean available;

    @ManyToOne
    private Airport airport;

    @Embedded
    private Location location;

    private double latitude;
    private double longitude;

    public Plane(String name, String model) {
        this.name = name;
        this.model = model;
    }
    // Additional constructor for easy instantiation
    public Plane(String name, String model, Location location, double latitude, double longitude) {
        this.name = name;
        this.model = model;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
