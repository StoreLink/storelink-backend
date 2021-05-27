package kz.storelink.service.storage;

import kz.storelink.model.storage.*;
import kz.storelink.model.user.User;
import kz.storelink.repository.storage.*;
import kz.storelink.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class StorageService {

    private StorageRepository storageRepository;
    private StorageTypeRepository storageTypeRepository;
    private StorageCategoryRepository storageCategoryRepository;
    private StorageStateRepository storageStateRepository;
    private UserRepository userRepository;
    private StorageParameterRepository storageParameterRepository;

    public List<Storage> showAllStorages() {
        return storageRepository.findAll();
    }

    public Storage getStorageById(Long storageId) {
        Storage storage = storageRepository.findById(storageId).orElse(null);
        System.out.println("Storage searching by id: " + storage);
        return storage;
    }

    public List<Storage> getStorageByName(String storageName) {
        return storageRepository.findByStorageNameLike(storageName);
    }

    public Storage saveStorage(Storage storage) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.getUserByUsername(username);
        storage.setUserId(user.getUserId());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        storage.setCreatedDate(timestamp);
        return storageRepository.save(storage);
    }

    public Storage updateStorage(Storage storage) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.getUserByUsername(username);
        if(storage.getUserId().equals(user.getUserId())) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            storage.setUpdatedDate(timestamp);
            storageRepository.save(storage);
        } else {
            System.out.println("It is not your storage!");
        }

        return storage;
    }

    public void deleteStorageById(Long storageId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Storage storage = storageRepository.findStorageByStorageId(storageId);
        String username = userDetails.getUsername();
        User user = userRepository.getUserByUsername(username);
        if(storage.getUserId().equals(user.getUserId())) {
            storageRepository.deleteById(storageId);
        } else {
            System.out.println("It is not your storage!");
        }
    }

    public StorageType assignStorageType(Storage storage, StorageType storageType) {
        Set<Storage> storages = storageType.getStorages();
        storages.add(storage);

        storageType.setStorages(storages);
        return storageTypeRepository.save(storageType);
    }
    public StorageType unassignStorageType(Storage storage, StorageType storageType) {
        Set<Storage> storages = storageType.getStorages();
        storages.remove(storage);

        storageType.setStorages(storages);
        return storageTypeRepository.save(storageType);
    }

    public StorageState assignStorageState(Storage storage, StorageState storageState) {
        Set<Storage> storages = storageState.getStorages();
        storages.add(storage);

        storageState.setStorages(storages);
        return storageStateRepository.save(storageState);
    }
    public StorageState unassignStorageState(Storage storage, StorageState storageState) {
        Set<Storage> storages = storageState.getStorages();
        storages.remove(storage);

        storageState.setStorages(storages);
        return storageStateRepository.save(storageState);
    }

    public StorageCategory assignStorageCategory(Storage storage, StorageCategory storageCategory) {
        Set<Storage> storages = storageCategory.getStorages();
        storages.add(storage);

        storageCategory.setStorages(storages);
        return storageCategoryRepository.save(storageCategory);
    }
    public StorageCategory unassignStorageCategory(Storage storage, StorageCategory storageCategory) {
        Set<Storage> storages = storageCategory.getStorages();
        storages.remove(storage);

        storageCategory.setStorages(storages);
        return storageCategoryRepository.save(storageCategory);
    }

    public List<Storage> getStorageByCategory(Long storageCategoryId) {
        return storageRepository.findStorageByStorageCategoryId(storageCategoryId);
    }

    public List<Storage> getStorageByType(Long storageTypeId) {
        return storageRepository.findStorageByStorageTypeId(storageTypeId);
    }

    public List<Storage> getStorageByState(Long storageStateId) {
        return storageRepository.findStorageByStorageStateId(storageStateId);
    }

    public StorageParameter assignParameterToStorage(Long storageId, Long parameterId) {
        StorageParameter storageParameter = new StorageParameter();
        storageParameter.setStorageId(storageId);
        storageParameter.setParameterId(parameterId);
        return storageParameter;
    }
    public void unassignParameterFromStorage(Long storageParameterId) {
        storageParameterRepository.deleteById(storageParameterId);
    }

}
