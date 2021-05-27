package kz.storelink.controller.storage;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.storage.StorageType;
import kz.storelink.service.storage.StorageTypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("storageType")
@AllArgsConstructor
public class StorageTypeController {

    private final StorageTypeService storageTypeService;

    @ApiOperation(value = "Show all storage types", response = List.class)
    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<StorageType> showAllStorageTypes() {
        return storageTypeService.showAllStorageTypes();
    }

    @ApiOperation(value = "Get storage type by id", response = List.class)
    @PostMapping("/{storageTypeId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageType getStorageTypeById(@PathVariable("storageTypeId") Long storageTypeId) {
        return storageTypeService.getStorageTypeById(storageTypeId);
    }

    @ApiOperation(value = "Get storage type by name", response = StorageType.class)
    @GetMapping("/name/{storageTypeName}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<StorageType> getStorageTypeByName(@PathVariable("storageTypeName") String storageTypeName) {
        List<StorageType> storageType = storageTypeService.getStorageTypeByName(storageTypeName);
        return storageType;
    }

    @ApiOperation(value = "Add new storage type into database", response = List.class)
    @PostMapping("/new")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageType saveStorageType(@RequestBody() StorageType storageType) {
        return storageTypeService.saveStorageType(storageType);
    }

    @ApiOperation(value = "Delete storage type from database", response = List.class)
    @PostMapping("/delete/{storageTypeId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteStorageTypeById(@PathVariable("storageTypeId") Long storageTypeId) {
        storageTypeService.deleteStorageTypeById(storageTypeId);
        return "storage type deleted successfully";
    }

    @ApiOperation(value = "Update all fields by id", response = StorageType.class)
    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageType updateStorageType(@RequestBody StorageType storageType) {
        return storageTypeService.saveStorageType(storageType);
    }

    @ApiOperation(value = "Update only storage type name", response = StorageType.class)
    @PatchMapping("update/name")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageType updateStorageTypeName(@RequestParam Long storageTypeId, @RequestParam String storageTypeName) {
        return storageTypeService.updateStorageTypeName(storageTypeId, storageTypeName);
    }

    @ApiOperation(value = "Update only storage type description", response = StorageType.class)
    @PatchMapping("update/description")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageType updateStorageTypeDescription(@RequestParam Long storageTypeId, @RequestParam String storageTypeDescription) {
        return storageTypeService.updateStorageTypeDescription(storageTypeId, storageTypeDescription);
    }

    @ApiOperation(value = "Update only storage type image", response = StorageType.class)
    @PatchMapping("update/image")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageType updateStorageTypeImage(@RequestParam Long storageTypeId, @RequestParam String storageTypeImage) {
        return storageTypeService.updateStorageTypeImage(storageTypeId, storageTypeImage);
    }

}
