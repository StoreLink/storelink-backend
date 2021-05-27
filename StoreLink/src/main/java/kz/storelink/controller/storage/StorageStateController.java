package kz.storelink.controller.storage;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.storage.StorageState;
import kz.storelink.service.storage.StorageStateService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storageState")
@AllArgsConstructor
public class StorageStateController {

    private final StorageStateService storageStateService;

    @ApiOperation(value = "Show all storage states", response = List.class)
    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<StorageState> showAllStorageStates() {
        return storageStateService.showAllStorageStates();
    }

    @ApiOperation(value = "Get storage states by id", response = List.class)
    @PostMapping("/{storageStateId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageState getStorageStateById(@PathVariable("storageStateId") Long storageStateId) {
        return storageStateService.getStorageStateById(storageStateId);
    }

    @ApiOperation(value = "Get storage state by name", response = StorageState.class)
    @GetMapping("/name/{storageStateName}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<StorageState> getStorageStateByName(@PathVariable("storageStateName") String storageStateName) {
        List<StorageState> storageState = storageStateService.getStorageStateByName(storageStateName);
        return storageState;
    }

    @ApiOperation(value = "Add new storage state into database", response = List.class)
    @PostMapping("/new")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageState saveStorageState(@RequestBody() StorageState storageState) {
        return storageStateService.saveStorageState(storageState);
    }

    @ApiOperation(value = "Delete storage state from database", response = List.class)
    @PostMapping("/delete/{storageStateId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteStorageStateById(@PathVariable("storageStateId") Long storageStateId) {
        storageStateService.deleteStorageStateById(storageStateId);
        return "Storage State deleted successfully";
    }

    @ApiOperation(value = "Update all fields by id", response = StorageState.class)
    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageState updateStorageState(@RequestBody StorageState storageState) {
        return storageStateService.saveStorageState(storageState);
    }

    @ApiOperation(value = "Update only storage state name", response = StorageState.class)
    @PatchMapping("update/name")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageState updateStorageStateName(@RequestParam Long storageStateId, @RequestParam String storageStateName) {
        return storageStateService.updateStorageStateName(storageStateId, storageStateName);
    }

    @ApiOperation(value = "Update only storage state description", response = StorageState.class)
    @PatchMapping("update/description")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageState updateStorageStateDescription(@RequestParam Long storageStateId, @RequestParam String storageStateDescription) {
        return storageStateService.updateStorageStateDescription(storageStateId, storageStateDescription);
    }

}
