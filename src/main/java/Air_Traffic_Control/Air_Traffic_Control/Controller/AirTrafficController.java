package Air_Traffic_Control.Air_Traffic_Control.Controller;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Airport;
import Air_Traffic_Control.Air_Traffic_Control.Entity.Plane;
import Air_Traffic_Control.Air_Traffic_Control.Entity.Result;
import Air_Traffic_Control.Air_Traffic_Control.Service.PlaneService;
import Air_Traffic_Control.Air_Traffic_Control.Service.AirportService;
import Air_Traffic_Control.Air_Traffic_Control.Service.FlightService;
import Air_Traffic_Control.Air_Traffic_Control.Service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class AirTrafficController {

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

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/airports")
    public String getAirports(Model model) {

        model.addAttribute("airports", airportService.getAllAirports());
        return "airports";
    }

    @PostMapping("/airports")
    public String addAirport(@RequestParam String name, @RequestParam String code, @RequestParam String location) {
        Airport newAirport = new Airport();
        newAirport.setName(name);
        newAirport.setCode(code);
        newAirport.setLocation(location);
        airportService.addAirport(newAirport);
        return "redirect:/airports";
    }

    @GetMapping("/planes")
    public String getPlanes(Model model) {
        model.addAttribute("planes", planeService.getAllPlane());
        return "planes";
    }

    @PostMapping("/planes")
    public String addPlane(@RequestParam String name, @RequestParam String code) {
        Plane newPlane = new Plane();
        newPlane.setName(name);
        newPlane.setModel(code);
        planeService.addPlane(newPlane);
        return "redirect:/planes";
    }


    @GetMapping("/route")
    public String showRouteForm() {
        return "routeForm";
    }

    @GetMapping("/shortest")
    public String getShortestRoute(@RequestParam(required = false) String origin,
                                   @RequestParam(required = false) String destination,
                                   Model model) {
        if (origin == null || destination == null) {
            return "redirect:/route";
        }

        Result result = routeService.findShortestPath(origin, destination);
        model.addAttribute("origin", origin);
        model.addAttribute("destination", destination);
        model.addAttribute("routeSteps", result.getRouteSteps());
        model.addAttribute("totalDistance", result.getTotalDistance());

        return "route";
    }
}
