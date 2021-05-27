package kz.storelink.controller.storage;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.storage.StorageCategory;
import kz.storelink.model.storage.StorageType;
import kz.storelink.service.storage.StorageCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storageCategory")
@AllArgsConstructor
public class StorageCategoryController {

    private final StorageCategoryService storageCategoryService;

    @ApiOperation(value = "Show all storage categories", response = List.class)
    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<StorageCategory> showAllStorageCategory() {
        return storageCategoryService.showAllStorageCategories();
    }

    @ApiOperation(value = "Get storage category by id", response = List.class)
    @PostMapping("/{storageCategoryId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageCategory getStorageCategoryById(@PathVariable("storageCategoryId") Long storageCategoryId) {
        return storageCategoryService.getStorageCategoryById(storageCategoryId);
    }

    @ApiOperation(value = "Get storage category by name", response = StorageType.class)
    @GetMapping("/name/{storageCategoryName}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<StorageCategory> getStorageCategoryByName(@PathVariable("storageCategoryName") String storageCategoryName) {
        List<StorageCategory> storageCategory = storageCategoryService.getStorageCategoryByName(storageCategoryName);
        return storageCategory;
    }

    @ApiOperation(value = "Add new storage category into database", response = List.class)
    @PostMapping("/new")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageCategory saveStorageCategory(@RequestBody() StorageCategory storageCategory) {
        return storageCategoryService.saveStorageCategory(storageCategory);
    }

    @ApiOperation(value = "Delete storage category from database", response = List.class)
    @PostMapping("/delete/{storageCategoryId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteStorageCategoryById(@PathVariable("storageCategoryId") Long storageCategoryId) {
        storageCategoryService.deleteStorageCategoryById(storageCategoryId);
        return "Storage category deleted successfully!";
    }

    @ApiOperation(value = "Update all fields by id", response = StorageCategory.class)
    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageCategory updateStorageCategory(@RequestBody StorageCategory storageCategory) {
        return storageCategoryService.saveStorageCategory(storageCategory);
    }

    @ApiOperation(value = "Update only storage category name", response = StorageCategory.class)
    @PatchMapping("update/name")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageCategory updateStorageCategoryName(@RequestParam Long storageCategoryId, @RequestParam String storageCategoryName) {
        return storageCategoryService.updateStorageCategoryName(storageCategoryId, storageCategoryName);
    }

    @ApiOperation(value = "Update only storage category description", response = StorageCategory.class)
    @PatchMapping("update/description")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageCategory updateStorageCategoryDescription(@RequestParam Long storageCategoryId, @RequestParam String storageCategoryDescription) {
        return storageCategoryService.updateStorageCategoryDescription(storageCategoryId, storageCategoryDescription);
    }

    @ApiOperation(value = "Update only storage category image", response = StorageCategory.class)
    @PatchMapping("update/image")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public StorageCategory updateStorageCategoryImage(@RequestParam Long storageCategoryId, @RequestParam String storageCategoryImage) {
        return storageCategoryService.updateStorageCategoryImage(storageCategoryId, storageCategoryImage);
    }

}
