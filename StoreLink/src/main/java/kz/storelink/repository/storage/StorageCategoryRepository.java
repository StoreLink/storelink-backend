package kz.storelink.repository.storage;

import kz.storelink.model.storage.StorageCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageCategoryRepository extends JpaRepository<StorageCategory, Long> {

    List<StorageCategory> findByStorageCategoryNameLike(String storageCategoryName);

}
