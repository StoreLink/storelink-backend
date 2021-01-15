package kz.storelink.repository.storage;

import kz.storelink.model.storage.StorageState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageStateRepository extends JpaRepository<StorageState, Long> {
}
