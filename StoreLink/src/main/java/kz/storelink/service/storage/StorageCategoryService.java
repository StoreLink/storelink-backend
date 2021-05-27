package kz.storelink.service.storage;

import kz.storelink.model.storage.StorageCategory;
import kz.storelink.repository.storage.StorageCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StorageCategoryService {

    private StorageCategoryRepository storageCategoryRepository;

    public List<StorageCategory> showAllStorageCategories() {
        return storageCategoryRepository.findAll();
    }

    public StorageCategory getStorageCategoryById(Long storageCategoryId) {
        StorageCategory storageCategory = storageCategoryRepository.findById(storageCategoryId).orElse(null);
        System.out.println("Storage Category searching by id: " + storageCategory);
        return storageCategory;
    }

    public List<StorageCategory> getStorageCategoryByName(String storageCategoryName) {
        System.out.println("Storage State searching by name '" + storageCategoryName + "' founded");
        return storageCategoryRepository.findByStorageCategoryNameLike(storageCategoryName);
    }

    public StorageCategory saveStorageCategory(StorageCategory storageCategory) {
        return storageCategoryRepository.save(storageCategory);
    }

    public void deleteStorageCategoryById(Long storageTypeId) {
        storageCategoryRepository.deleteById(storageTypeId);
    }

    public StorageCategory updateStorageCategoryName(Long storageCategoryId, String storageCategoryName) {
        StorageCategory storageCategory = storageCategoryRepository.findById(storageCategoryId).get();
        storageCategory.setStorageCategoryName(storageCategoryName);
        return storageCategoryRepository.save(storageCategory);
    }

    public StorageCategory updateStorageCategoryDescription(Long storageCategoryId, String storageCategoryDescription) {
        StorageCategory storageCategory = storageCategoryRepository.findById(storageCategoryId).get();
        storageCategory.setStorageCategoryDescription(storageCategoryDescription);
        return storageCategoryRepository.save(storageCategory);
    }

    public StorageCategory updateStorageCategoryImage(Long storageTypeId, String storageCategoryImage) {
        StorageCategory storageCategory = storageCategoryRepository.findById(storageTypeId).get();
        storageCategory.setStorageCategoryImage(storageCategoryImage);
        return storageCategoryRepository.save(storageCategory);
    }

}
