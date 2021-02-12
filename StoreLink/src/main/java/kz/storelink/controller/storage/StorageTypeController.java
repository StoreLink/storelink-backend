package kz.storelink.controller.storage;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.storage.StorageType;
import kz.storelink.service.storage.StorageTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storageType")
@AllArgsConstructor
public class StorageTypeController {

    private final StorageTypeService storageTypeService;

    @ApiOperation(value = "Get storage type by id", response = List.class)
    @GetMapping("/{storage_type_id}")
    public StorageType findStorageTypeById(@PathVariable("storage_type_id") Long storage_type_id) {
        return storageTypeService.findStorageTypeById(storage_type_id);
    }

    @ApiOperation(value = "Add a new storage type to the database", response = List.class)
    @PostMapping("/newStorageType")
    public StorageType saveStorageType(@RequestBody() StorageType storageType) {
        return storageTypeService.saveStorageType(storageType);
    }

    @ApiOperation(value = "Add a new storage type to the database", response = List.class)
    @PostMapping("/deleteStorageType/{storage_type_id}")
    public String deleteStorageTypeById(@PathVariable("storage_type_id") Long storage_type_id) {
        storageTypeService.deleteStorageTypeById(storage_type_id);
        return "storage type deleted successfully";
    }

    @ApiOperation(value = "Get all storage types", response = List.class)
    @GetMapping("")
    public List<StorageType> getAllStorageTypes() {
        return storageTypeService.showAllStorageTypes();
    }

    @ApiOperation(value = "Update all fields by id", response = StorageType.class)
    @PutMapping("/update")
    public StorageType updateStorageType(@RequestBody StorageType storageType) {
        return storageTypeService.saveStorageType(storageType);
    }

    @ApiOperation(value = "Update only storage type name", response = StorageType.class)
    @PatchMapping("update/name")
    public StorageType updateStorageTypeName(@RequestParam Long storage_type_id, @RequestParam String storage_type_name) {
        return storageTypeService.updateStorageTypeName(storage_type_id, storage_type_name);
    }

}
