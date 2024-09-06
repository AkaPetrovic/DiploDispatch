package rs.ac.bg.fon.njt.DiploDispatch.loadItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadItemRepository extends JpaRepository<LoadItem, LoadItemId> {
}
