package kz.storelink.repository.storage;

import kz.storelink.model.storage.StorageState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageStateRepository extends JpaRepository<StorageState, Long> {

    List<StorageState> findByStorageStateNameLike(String storageStateName);

}
