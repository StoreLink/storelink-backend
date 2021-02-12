package kz.storelink.service.storage;

import kz.storelink.model.storage.StorageType;
import kz.storelink.repository.storage.StorageTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class StorageTypeService {

    private StorageTypeRepository storageTypeRepository;

    public StorageType findStorageTypeById(Long storage_type_id) {
        StorageType storageType = storageTypeRepository.findById(storage_type_id).orElse(null);
        System.out.println("Storage Type searching by id: "+storageType);
        return storageType;
    }

    public List<StorageType> showAllStorageTypes() {
        return storageTypeRepository.findAll();
    }

    public void deleteStorageTypeById(Long storage_type_id) {
        storageTypeRepository.deleteById(storage_type_id);
    }

    public StorageType saveStorageType(StorageType storageType){
        return storageTypeRepository.save(storageType);
    }

    public StorageType updateStorageTypeName(Long storage_type_id, String storage_type_name){
        StorageType storageType = storageTypeRepository.findById(storage_type_id).get();
        storageType.setStorage_type_name(storage_type_name);
        return storageTypeRepository.save(storageType);
    }

}
