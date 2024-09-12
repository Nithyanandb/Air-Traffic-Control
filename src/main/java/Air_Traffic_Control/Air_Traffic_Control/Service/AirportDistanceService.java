package Air_Traffic_Control.Air_Traffic_Control.Service;

import Air_Traffic_Control.Air_Traffic_Control.Entity.AirportDistance;
import Air_Traffic_Control.Air_Traffic_Control.Repository.AirportDistanceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AirportDistanceService {

    private static final Logger logger = LoggerFactory.getLogger(AirportDistanceService.class);

    private final AirportDistanceRepository airportDistanceRepo;

    @Transactional
    public void saveAirportDistance(AirportDistance airportDistance) {
        logger.info("Saving airport distance: {}", airportDistance);
        airportDistanceRepo.save(airportDistance);
    }
}
