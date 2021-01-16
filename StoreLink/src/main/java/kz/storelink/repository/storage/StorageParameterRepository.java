package kz.storelink.repository.storage;

import kz.storelink.model.storage.StorageParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageParameterRepository extends JpaRepository<StorageParameter, Long> {
}
