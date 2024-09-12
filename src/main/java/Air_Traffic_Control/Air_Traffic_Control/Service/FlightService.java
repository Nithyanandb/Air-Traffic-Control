package Air_Traffic_Control.Air_Traffic_Control.Service;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Flight;
import Air_Traffic_Control.Air_Traffic_Control.Repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightsByOrigin(Long airportId) {
        return flightRepository.findByOriginId(airportId); // You need to define this method in your repository
    }

    public void addFlight(Long planeId, Long originId, Long destinationId, double distance) {
        // Implement flight addition logic
    }
}
