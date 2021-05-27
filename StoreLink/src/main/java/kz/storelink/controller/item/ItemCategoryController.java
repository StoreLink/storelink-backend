package kz.storelink.controller.item;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.item.ItemCategory;
import kz.storelink.service.item.ItemCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemCategory")
@AllArgsConstructor
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    @ApiOperation(value = "Show all item categories", response = List.class)
    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ItemCategory> showAllItemCategory() {
        return itemCategoryService.showAllItemCategory();
    }

    @ApiOperation(value = "Get ctem category by id", response = List.class)
    @PostMapping("/{itemCategoryId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ItemCategory getItemCategoryById(@PathVariable("itemCategoryId") Long itemCategoryId) {
        return itemCategoryService.getItemCategoryById(itemCategoryId);
    }

    @ApiOperation(value = "Get item category by name", response = ItemCategory.class)
    @GetMapping("/name/{itemCategoryName}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ItemCategory> getItemCategoryByName(@PathVariable("itemCategoryName") String itemCategoryName) {
        List<ItemCategory> itemCategory = itemCategoryService.getItemCategoryByName(itemCategoryName);
        return itemCategory;
    }

    @ApiOperation(value = "Add new item category into database", response = List.class)
    @PostMapping("/new")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ItemCategory saveItemCategory(@RequestBody() ItemCategory itemCategory) {
        return itemCategoryService.saveItemCategory(itemCategory);
    }

    @ApiOperation(value = "Delete item category from database", response = List.class)
    @PostMapping("/delete/{itemCategoryId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteItemCategoryById(@PathVariable("itemCategoryId") Long itemCategoryId) {
        itemCategoryService.deleteItemCategoryById(itemCategoryId);
        return "Item Category deleted successfully";
    }

    @ApiOperation(value = "Update all fields by id", response = ItemCategory.class)
    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ItemCategory updateItemCategory(@RequestBody ItemCategory itemCategory) {
        return itemCategoryService.saveItemCategory(itemCategory);
    }

    @ApiOperation(value = "Update only item category name", response = ItemCategory.class)
    @PatchMapping("update/name")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ItemCategory updateItemCategoryName(@RequestParam Long itemCategoryId, @RequestParam String itemCategoryName) {
        return itemCategoryService.updateItemCategoryName(itemCategoryId, itemCategoryName);
    }

    @ApiOperation(value = "Update only item category description", response = ItemCategory.class)
    @PatchMapping("update/description")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ItemCategory updateItemCategoryDescription(@RequestParam Long itemCategoryId, @RequestParam String itemCategoryDescription) {
        return itemCategoryService.updateItemCategoryDescription(itemCategoryId, itemCategoryDescription);
    }

    @ApiOperation(value = "Update only item category image", response = ItemCategory.class)
    @PatchMapping("update/image")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ItemCategory updateItemCategoryImage(@RequestParam Long itemCategoryId, @RequestParam String itemCategoryImage) {
        return itemCategoryService.updateItemCategoryImage(itemCategoryId, itemCategoryImage);
    }

}
