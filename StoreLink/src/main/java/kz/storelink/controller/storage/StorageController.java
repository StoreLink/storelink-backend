package kz.storelink.controller.storage;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.storage.*;
import kz.storelink.service.storage.StorageCategoryService;
import kz.storelink.service.storage.StorageService;
import kz.storelink.service.storage.StorageStateService;
import kz.storelink.service.storage.StorageTypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
@AllArgsConstructor
public class StorageController {

    private StorageService storageService;
    private StorageTypeService storageTypeService;
    private StorageCategoryService storageCategoryService;
    private StorageStateService storageStateService;

    @ApiOperation(value = "Get all storages", response = List.class)
    @GetMapping("")
    public List<Storage> showAllStorages() {
        return storageService.showAllStorages();
    }

    @ApiOperation(value = "Get storage by id", response = List.class)
    @PostMapping("/{storageId}")
    public Storage getStorageById(@PathVariable("storageId") Long storageId) {
        return storageService.getStorageById(storageId);
    }

    @ApiOperation(value = "Get storage by name", response = Storage.class)
    @GetMapping("/name/{storageName}")
    public List<Storage> getStorageByName(@PathVariable("storageName") String storageName) {
        List<Storage> storage = storageService.getStorageByName(storageName);
        return storage;
    }

    @ApiOperation(value = "Add a new storage into database", response = List.class)
    @PostMapping("/newStorage")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Storage saveStorage(@RequestBody() Storage storage) {
        return storageService.saveStorage(storage);
    }

    @ApiOperation(value = "Delete storage from database", response = List.class)
    @PostMapping("/delete/{storageId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteStorageById(@PathVariable("storageId") Long storageId) {
        storageService.deleteStorageById(storageId);
        return "Storage deleted successfully!";
    }

    @ApiOperation(value = "Update all fields by id", response = Storage.class)
    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Storage updateStorage(@RequestBody Storage storage) {
        return storageService.updateStorage(storage);
    }

    @ApiOperation(value = "Assign type to storage", response = Storage.class)
    @PostMapping("/assignType")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageType assignTypeToStorage(@RequestParam("storageId") Long storageId,
                                           @RequestParam("storageTypeId") Long storageTypeId) {
        Storage storage = storageService.getStorageById(storageId);
        StorageType storageType = storageTypeService.getStorageTypeById(storageTypeId);
        return storageService.assignStorageType(storage, storageType);
    }
    @ApiOperation(value = "Unassign type to storage", response = Storage.class)
    @PostMapping("/unassignType")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageType unassignTypeToStorage(@RequestParam("storageId") Long storageId,
                                             @RequestParam("storageTypeId") Long storageTypeId) {
        Storage storage = storageService.getStorageById(storageId);
        StorageType storageType = storageTypeService.getStorageTypeById(storageTypeId);
        return storageService.unassignStorageType(storage, storageType);
    }

    @ApiOperation(value = "Assign category to storage", response = Storage.class)
    @PostMapping("/assignCategory")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageCategory assignCategoryToStorage(@RequestParam("storageId") Long storageId,
                                               @RequestParam("storageCategoryId") Long storageCategoryId) {
        Storage storage = storageService.getStorageById(storageId);
        StorageCategory storageCategory = storageCategoryService.getStorageCategoryById(storageCategoryId);
        return storageService.assignStorageCategory(storage, storageCategory);
    }
    @ApiOperation(value = "Unassign category to storage", response = Storage.class)
    @PostMapping("/unassignCategory")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageCategory unassignCategoryToStorage(@RequestParam("storageId") Long storageId,
                                             @RequestParam("storageCategoryId") Long storageCategoryId) {
        Storage storage = storageService.getStorageById(storageId);
        StorageCategory storageCategory = storageCategoryService.getStorageCategoryById(storageCategoryId);
        return storageService.unassignStorageCategory(storage, storageCategory);
    }

    @ApiOperation(value = "Assign state to storage", response = Storage.class)
    @PostMapping("/assignState")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageState assignStateToStorage(@RequestParam("storageId") Long storageId,
                                                @RequestParam("storageStateId") Long storageStateId) {
        Storage storage = storageService.getStorageById(storageId);
        StorageState storageState = storageStateService.getStorageStateById(storageStateId);
        return storageService.assignStorageState(storage, storageState);
    }
    @ApiOperation(value = "Unassign state to storage", response = Storage.class)
    @PostMapping("/unassignState")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageState unassignStateToStorage(@RequestParam("storageId") Long storageId,
                                                     @RequestParam("storageStateId") Long storageStateId) {
        Storage storage = storageService.getStorageById(storageId);
        StorageState storageState = storageStateService.getStorageStateById(storageStateId);
        return storageService.unassignStorageState(storage, storageState);
    }

    @ApiOperation(value = "Get storages by category", response = List.class)
    @PostMapping("/byCategory/{storageCategoryId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Storage> getStorageByCategory(@PathVariable("storageCategoryId") Long storageCategoryId) {
        List<Storage> storage = storageService.getStorageByCategory(storageCategoryId);
        return storage;
    }

    @ApiOperation(value = "Get storages by type", response = List.class)
    @PostMapping("/byType/{storageTypeId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Storage> getStorageByType(@PathVariable("storageTypeId") Long storageTypeId) {
        List<Storage> storage = storageService.getStorageByType(storageTypeId);
        return storage;
    }

    @ApiOperation(value = "Get storages by state", response = List.class)
    @PostMapping("/byState/{storageStateId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Storage> getStorageByState(@PathVariable("storageStateId") Long storageStateId) {
        List<Storage> storage = storageService.getStorageByState(storageStateId);
        return storage;
    }

    @ApiOperation(value = "Assign parameter to storage", response = StorageParameter.class)
    @PostMapping("/assignParameter")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageParameter assignParameterToStorage(@RequestParam("storageId") Long storageId,
                                                    @RequestParam("parameterId") Long parameterId) {
        return storageService.assignParameterToStorage(storageId, parameterId);
    }
    @ApiOperation(value = "Unassign parameter from storage by id", response = List.class)
    @PostMapping("/deleteParameter/{storageParameterId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String unassignParameterToStorage(@PathVariable("storageParameterId") Long storageParameterId) {
        storageService.unassignParameterFromStorage(storageParameterId);
        return "Parameter unassigned successfully!";
    }

}
