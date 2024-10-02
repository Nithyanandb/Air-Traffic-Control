package Air_Traffic_Control.Air_Traffic_Control.Repository;

import Air_Traffic_Control.Air_Traffic_Control.Entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroplaneRepository extends JpaRepository<Plane, Long> {

}
