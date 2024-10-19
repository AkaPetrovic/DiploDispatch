package rs.ac.bg.fon.njt.DiploDispatch.loadItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoadItemRepository extends JpaRepository<LoadItem, LoadItemId> {
    List<LoadItem> findByTruckLoad_Id(Long truckLoadId);
}
