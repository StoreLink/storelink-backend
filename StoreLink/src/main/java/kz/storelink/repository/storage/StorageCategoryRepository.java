package kz.storelink.repository.storage;

import kz.storelink.model.storage.StorageCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageCategoryRepository extends JpaRepository<StorageCategory, Long> {
}
