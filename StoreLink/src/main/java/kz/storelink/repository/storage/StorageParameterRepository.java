package kz.storelink.repository.storage;

import kz.storelink.model.storage.StorageParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageParameterRepository extends JpaRepository<StorageParameter, Long> {
}
