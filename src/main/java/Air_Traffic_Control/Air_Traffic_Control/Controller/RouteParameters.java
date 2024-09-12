package Air_Traffic_Control.Air_Traffic_Control.Controller;

public class RouteParameters {
    private String origin;
    private String destination;

    public RouteParameters() {}

    public RouteParameters(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    // Getters and setters
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

