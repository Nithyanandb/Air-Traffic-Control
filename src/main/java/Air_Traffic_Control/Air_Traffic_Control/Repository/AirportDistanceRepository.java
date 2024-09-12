package Air_Traffic_Control.Air_Traffic_Control.Repository;

import Air_Traffic_Control.Air_Traffic_Control.Entity.AirportDistance;
import Air_Traffic_Control.Air_Traffic_Control.Entity.AirportDistanceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportDistanceRepository extends JpaRepository<AirportDistance, AirportDistanceId> {
}
