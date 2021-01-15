package kz.storelink.repository.storage;

import kz.storelink.model.storage.StorageCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageCategoryRepository extends JpaRepository<StorageCategory, Long> {
}
