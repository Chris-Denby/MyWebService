package Publisher.dao;

import Publisher.model.Thing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThingJPARepository extends JpaRepository<Thing,Long>
{
}
