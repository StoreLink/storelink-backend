package kz.storelink.service.storage;

import kz.storelink.model.storage.StorageState;
import kz.storelink.repository.storage.StorageStateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StorageStateService {

    private StorageStateRepository storageStateRepository;

    public List<StorageState> showAllStorageStates() {
        return storageStateRepository.findAll();
    }

    public StorageState getStorageStateById(Long storageStateId) {
        StorageState storageState = storageStateRepository.findById(storageStateId).orElse(null);
        System.out.println("Storage State searching by id: " + storageState);
        return storageState;
    }

    public List<StorageState> getStorageStateByName(String storageStateName) {
        System.out.println("Storage State searching by name '" + storageStateName + "' founded");
        return storageStateRepository.findByStorageStateNameLike(storageStateName);
    }

    public StorageState saveStorageState(StorageState storageState) {
        return storageStateRepository.save(storageState);
    }

    public void deleteStorageStateById(Long storageStateId) {
        storageStateRepository.deleteById(storageStateId);
    }

    public StorageState updateStorageStateName(Long storageStateId, String storageStateName) {
        StorageState storageState = storageStateRepository.findById(storageStateId).get();
        storageState.setStorageStateName(storageStateName);
        return storageStateRepository.save(storageState);
    }

    public StorageState updateStorageStateDescription(Long storageStateId, String storageStateDescription) {
        StorageState storageState = storageStateRepository.findById(storageStateId).get();
        storageState.setStorageStateDescription(storageStateDescription);
        return storageStateRepository.save(storageState);
    }

}
