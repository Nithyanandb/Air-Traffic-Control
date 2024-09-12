package Air_Traffic_Control.Air_Traffic_Control.Controller;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Airport;
import Air_Traffic_Control.Air_Traffic_Control.Entity.Flight;
import Air_Traffic_Control.Air_Traffic_Control.Entity.Plane;
import Air_Traffic_Control.Air_Traffic_Control.Service.AirportService;
import Air_Traffic_Control.Air_Traffic_Control.Service.FlightService;
import Air_Traffic_Control.Air_Traffic_Control.Service.PlaneService;
import Air_Traffic_Control.Air_Traffic_Control.Service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class AirTrafficController {

    private static final Logger logger = LoggerFactory.getLogger(AirTrafficController.class);

    private final AirportService airportService;
    private final FlightService flightService;
    private final PlaneService planeService;
    private final RouteService routeService;

    public AirTrafficController(AirportService airportService, FlightService flightService, PlaneService planeService, RouteService routeService) {
        this.airportService = airportService;
        this.flightService = flightService;
        this.planeService = planeService;
        this.routeService = routeService;
    }

    // Serve the index page on root access
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("airports", airportService.getAllAirports());
        model.addAttribute("planes", planeService.getAllPlanes());
        return "index"; // Corresponds to Thymeleaf template 'index.html'
    }

    // Get list of airports
    @GetMapping("/airports")
    public String getAirports(Model model) {
        List<Airport> airports = airportService.getAllAirports();
        model.addAttribute("airports", airports);
        return "airports"; // Corresponds to Thymeleaf template 'airports.html'
    }

    // Add a new airport
    @PostMapping("/airports")
    public String addAirport(@RequestParam String name, @RequestParam String code) {
        try {
            airportService.saveAirport(new Airport(name, code));
        } catch (Exception e) {
            logger.error("Error adding airport: ", e);
            // Handle error (e.g., show error page or message)
        }
        return "redirect:/airports";
    }

    // Add a new flight
    @PostMapping("/flights")
    public String addFlight(@RequestParam Long planeId, @RequestParam Long originId, @RequestParam Long destinationId, @RequestParam double distance) {
        try {
            flightService.addFlight(planeId, originId, destinationId, distance);
        } catch (Exception e) {
            logger.error("Error adding flight: ", e);
            // Handle error (e.g., show error page or message)
        }
        return "redirect:/flights";
    }

    // Get list of planes
    @GetMapping("/planes")
    public String getPlanes(Model model) {
        List<Plane> planes = planeService.getAllPlanes();
        model.addAttribute("planes", planes);
        return "planes"; // Corresponds to Thymeleaf template 'planes.html'
    }

    // Add a new plane
    @PostMapping("/planes")
    public String addPlane(@RequestParam String name, @RequestParam String model) {
        try {
            planeService.savePlane(new Plane(name, model));
        } catch (Exception e) {
            logger.error("Error adding plane: ", e);
            // Handle error (e.g., show error page or message)
        }
        return "redirect:/planes";
    }

    @GetMapping("/route/shortest")
    public String getShortestRoute(@RequestParam(required = false) String origin,
                                   @RequestParam(required = false) String destination,
                                   Model model) {
        if (origin == null || destination == null) {
            model.addAttribute("error", "Both origin and destination parameters are required.");
            return "error"; // Corresponds to Thymeleaf template 'error.html'
        }

        List<Airport> route = routeService.findShortestRoute(origin, destination);
        model.addAttribute("route", route);
        model.addAttribute("param", new RouteParameters(origin, destination));

        return "route"; // Corresponds to Thymeleaf template 'route.html'
    }

}
