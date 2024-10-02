package Air_Traffic_Control.Air_Traffic_Control.Repository;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginId(Long airportId);
}
