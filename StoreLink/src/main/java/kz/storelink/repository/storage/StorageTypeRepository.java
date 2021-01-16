package kz.storelink.repository.storage;

import kz.storelink.model.storage.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageTypeRepository extends JpaRepository<StorageType, Long> {
}
