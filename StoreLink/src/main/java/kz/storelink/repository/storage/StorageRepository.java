package kz.storelink.repository.storage;

import kz.storelink.model.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
}
