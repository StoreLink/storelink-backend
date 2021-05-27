package kz.storelink.repository.storage;

import kz.storelink.model.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    List<Storage> findByStorageNameLike(String storageName);

    Storage findStorageByStorageId(Long storageId);

    @Query(value = "select s.* from storage s, storage_category_storages scs, storage_category sc " +
            "where s.storage_id = scs.storages_storage_id " +
            "and sc.storage_category_id=scs.storage_category_storage_category_id " +
            "and sc.storage_category_id = ?1;", nativeQuery = true)
    List<Storage> findStorageByStorageCategoryId(Long storageCategoryId);

    @Query(value = "select s.* from storage s, storage_state_storages scs, storage_statte sc " +
            "where s.storage_id = scs.storages_storage_id " +
            "and sc.storage_state_id=scs.storage_state_storage_state_id " +
            "and sc.storage_state_id = ?1;", nativeQuery = true)
    List<Storage> findStorageByStorageStateId(Long storageStateId);

    @Query(value = "select s.* from storage s, storage_type_storages scs, storage_type sc " +
            "where s.storage_id = scs.storages_storage_id " +
            "and sc.storage_typ_id=scs.storage_type_storage_type_id " +
            "and sc.storage_type_id = ?1;", nativeQuery = true)
    List<Storage> findStorageByStorageTypeId(Long storageTypeId);

}
