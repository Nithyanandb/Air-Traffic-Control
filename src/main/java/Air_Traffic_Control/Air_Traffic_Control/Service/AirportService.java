package Air_Traffic_Control.Air_Traffic_Control.Service;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Airport;
import Air_Traffic_Control.Air_Traffic_Control.Repository.AirportRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public void addAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public Airport getAirportByCode(String code) {
        return airportRepository.findByCode(code);
    }
}
