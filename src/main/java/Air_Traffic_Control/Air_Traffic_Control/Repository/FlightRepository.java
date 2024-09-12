package Air_Traffic_Control.Air_Traffic_Control.Repository;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginId(Long airportId);
}
