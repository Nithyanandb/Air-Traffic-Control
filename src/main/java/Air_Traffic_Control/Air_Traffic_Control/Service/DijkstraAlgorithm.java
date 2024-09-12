package Air_Traffic_Control.Air_Traffic_Control.Service;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Airport;
import Air_Traffic_Control.Air_Traffic_Control.Entity.Flight;

import java.util.*;

public class DijkstraAlgorithm {

    // Method to find the shortest path using Dijkstra's algorithm
    public List<Airport> findShortestPath(Map<Airport, List<Flight>> graph, Airport start, Airport end) {
        // Initialize data structures
        Map<Airport, Double> distances = new HashMap<>();
        Map<Airport, Airport> previousNodes = new HashMap<>();
        PriorityQueue<Airport> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        List<Airport> path = new ArrayList<>();

        // Set initial distances to infinity and start node distance to 0
        for (Airport airport : graph.keySet()) {
            distances.put(airport, Double.MAX_VALUE);
            previousNodes.put(airport, null);
        }
        distances.put(start, 0.0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Airport current = priorityQueue.poll();

            if (current.equals(end)) {
                // Reconstruct the path from end to start
                while (previousNodes.get(current) != null) {
                    path.add(current);
                    current = previousNodes.get(current);
                }
                path.add(start);
                Collections.reverse(path);
                return path;
            }

            for (Flight flight : graph.get(current)) {
                Airport neighbor = flight.getDestination();
                double newDist = distances.get(current) + flight.getDistance();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previousNodes.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        return path; // Return empty path if no route found
    }
}
