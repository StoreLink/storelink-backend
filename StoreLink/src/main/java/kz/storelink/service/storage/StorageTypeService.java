package kz.storelink.service.storage;

import kz.storelink.model.storage.StorageType;
import kz.storelink.repository.storage.StorageTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StorageTypeService {

    private StorageTypeRepository storageTypeRepository;

    public List<StorageType> showAllStorageTypes() {
        return storageTypeRepository.findAll();
    }

    public StorageType getStorageTypeById(Long storageTypeId) {
        StorageType storageType = storageTypeRepository.findById(storageTypeId).orElse(null);
        System.out.println("Storage Type searching by id: " + storageType);
        return storageType;
    }

    public List<StorageType> getStorageTypeByName(String storageTypeName) {
        System.out.println("Storage Type searching by name '" + storageTypeName + "' founded");
        return storageTypeRepository.findByStorageTypeNameLike(storageTypeName);
    }

    public StorageType saveStorageType(StorageType storageType){
        return storageTypeRepository.save(storageType);
    }

    public void deleteStorageTypeById(Long storageTypeId) {
        storageTypeRepository.deleteById(storageTypeId);
    }

    public StorageType updateStorageTypeName(Long storageTypeId, String storageTypeName) {
        StorageType storageType = storageTypeRepository.findById(storageTypeId).get();
        storageType.setStorageTypeName(storageTypeName);
        return storageTypeRepository.save(storageType);
    }

    public StorageType updateStorageTypeDescription(Long storageTypeId, String storageTypeDescription) {
        StorageType storageType = storageTypeRepository.findById(storageTypeId).get();
        storageType.setStorageTypeDescription(storageTypeDescription);
        return storageTypeRepository.save(storageType);
    }

    public StorageType updateStorageTypeImage(Long storageTypeId, String storageTypeImage) {
        StorageType storageType = storageTypeRepository.findById(storageTypeId).get();
        storageType.setStorageTypeImage(storageTypeImage);
        return storageTypeRepository.save(storageType);
    }

}
