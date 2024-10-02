package Air_Traffic_Control.Air_Traffic_Control.Service;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Airport;
import Air_Traffic_Control.Air_Traffic_Control.Entity.Flight;
import Air_Traffic_Control.Air_Traffic_Control.Entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteService {

    private final AirportService airportService;
    private final FlightService flightService;
    private final DijkstraAlgorithm dijkstraAlgorithm;

    @Autowired
    public RouteService(AirportService airportService, FlightService flightService, DijkstraAlgorithm dijkstraAlgorithm) {
        this.airportService = airportService;
        this.flightService = flightService;
        this.dijkstraAlgorithm = dijkstraAlgorithm;
    }

    public Result findShortestPath(String originCode, String destinationCode) {
        Airport start = airportService.getAirportByCode(originCode);
        Airport end = airportService.getAirportByCode(destinationCode);

        if (start == null || end == null) {
            return new Result(Collections.emptyList(), 0.0);
        }

        Map<Airport, List<Flight>> graph = buildGraph();
        return dijkstraAlgorithm.findShortestPath(graph, start, end);
    }

    private Map<Airport, List<Flight>> buildGraph() {
        List<Airport> airports = airportService.getAllAirports();
        List<Flight> flights = flightService.getAllFlights();
        Map<Airport, List<Flight>> graph = new HashMap<>();

        // Initialize graph
        for (Airport airport : airports) {
            graph.put(airport, new ArrayList<>());
        }

        // Build graph with flights
        for (Flight flight : flights) {
            graph.get(flight.getOrigin()).add(flight);
        }

        return graph;
    }
}
