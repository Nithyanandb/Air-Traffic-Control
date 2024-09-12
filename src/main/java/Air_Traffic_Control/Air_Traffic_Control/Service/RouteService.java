package Air_Traffic_Control.Air_Traffic_Control.Service;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Airport;
import Air_Traffic_Control.Air_Traffic_Control.Entity.Flight;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteService {

    private final AirportService airportService;
    private final FlightService flightService;
    private final DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

    public RouteService(AirportService airportService, FlightService flightService) {
        this.airportService = airportService;
        this.flightService = flightService;
    }

    public List<Airport> findShortestRoute(String originCode, String destinationCode) {
        Airport start = airportService.getAirportByCode(originCode);
        Airport end = airportService.getAirportByCode(destinationCode);

        if (start == null || end == null) {
            throw new IllegalArgumentException("Invalid airport code.");
        }

        // Build the graph
        Map<Airport, List<Flight>> graph = buildGraph();

        return dijkstraAlgorithm.findShortestPath(graph, start, end);
    }

    private Map<Airport, List<Flight>> buildGraph() {
        Map<Airport, List<Flight>> graph = new HashMap<>();
        List<Airport> airports = airportService.getAllAirports();
        for (Airport airport : airports) {
            graph.put(airport, flightService.getFlightsByOrigin(airport.getId()));
        }
        return graph;
    }
}
