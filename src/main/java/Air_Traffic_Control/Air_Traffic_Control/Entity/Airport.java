package Air_Traffic_Control.Air_Traffic_Control.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String airportCode;  // Ensure this field name matches the constructor and other references

    @Embedded
    private Location location;

    private int groundParkingSpots;
    private boolean availability;

    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Plane> groundedPlanes = new HashSet<>();

    // Constructor with name and airportCode
    public Airport(String name, String airportCode) {
        this.name = name;
        this.airportCode = airportCode;
    }

    // Constructor with all fields
    public Airport(String name, String airportCode, Location location, int groundParkingSpots, boolean availability) {
        this.name = name;
        this.airportCode = airportCode;  // Use airportCode here
        this.location = location;
        this.groundParkingSpots = groundParkingSpots;
        this.availability = availability;
    }
}
