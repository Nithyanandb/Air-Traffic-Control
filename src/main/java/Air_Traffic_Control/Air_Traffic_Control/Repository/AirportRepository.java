package Air_Traffic_Control.Air_Traffic_Control.Repository;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findByAirportCode(String code);
}
