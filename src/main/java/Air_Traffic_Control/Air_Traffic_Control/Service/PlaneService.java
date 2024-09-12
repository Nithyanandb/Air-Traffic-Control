package Air_Traffic_Control.Air_Traffic_Control.Service;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Plane;
import Air_Traffic_Control.Air_Traffic_Control.Repository.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;

    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public void savePlane(Plane plane) {
        planeRepository.save(plane);
    }
}
