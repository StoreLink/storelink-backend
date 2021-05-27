package kz.storelink.controller.item;

import io.swagger.annotations.ApiOperation;
import kz.storelink.model.item.Item;
import kz.storelink.model.item.ItemCategory;
import kz.storelink.service.item.ItemCategoryService;
import kz.storelink.service.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ItemCategoryService itemCategoryService;

    @ApiOperation(value = "Get all items", response = List.class)
    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Item> showAllItems() {
        return itemService.showAllItems();
    }

    @ApiOperation(value = "Get item by id", response = List.class)
    @PostMapping("/{itemId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Item getItemById(@PathVariable("itemId") Long itemId) {
        return itemService.getItemById(itemId);
    }

    @ApiOperation(value = "Get item by name", response = Item.class)
    @GetMapping("/name/{itemName}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Item> getItemByName(@PathVariable("itemName") String itemName) {
        List<Item> item = itemService.getItemByName(itemName);
        return item;
    }

    @ApiOperation(value = "Add a new item into database", response = List.class)
    @PostMapping("/newItem")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Item saveItem(@RequestBody() Item item) {
        return itemService.saveItem(item);
    }

    @ApiOperation(value = "Delete item from database", response = List.class)
    @PostMapping("/delete/{itemId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteItemById(@PathVariable("itemId") Long itemId) {
        itemService.deleteItemById(itemId);
        return "Item deleted successfully!";
    }

    @ApiOperation(value = "Update all fields by id", response = Item.class)
    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @ApiOperation(value = "Assign category to item", response = Item.class)
    @PostMapping("/assignCategory")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ItemCategory assignCategoryToItem(@RequestParam("itemId") Long itemId,
                                             @RequestParam("itemCategoryId") Long itemCategoryId) {
        Item item = itemService.getItemById(itemId);
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemCategoryId);
        return itemService.assignItemCategory(item, itemCategory);
    }
    @ApiOperation(value = "Unassign category to item", response = Item.class)
    @PostMapping("/unassignCategory")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ItemCategory unassignCategoryToItem(@RequestParam("itemId") Long itemId,
                                             @RequestParam("itemCategoryId") Long itemCategoryId) {
        Item item = itemService.getItemById(itemId);
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemCategoryId);
        return itemService.unassignItemCategory(item, itemCategory);
    }

}
