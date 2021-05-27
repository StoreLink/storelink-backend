package kz.storelink.service.item;

import kz.storelink.model.item.ItemCategory;
import kz.storelink.repository.item.ItemCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemCategoryService {

    private ItemCategoryRepository itemCategoryRepository;

    public List<ItemCategory> showAllItemCategory() {
        return itemCategoryRepository.findAll();
    }

    public ItemCategory getItemCategoryById(Long itemCategoryId) {
        ItemCategory itemCategory = itemCategoryRepository.findById(itemCategoryId).orElse(null);
        System.out.println("Item Category searching by id: " + itemCategory);
        return itemCategory;
    }

    public List<ItemCategory> getItemCategoryByName(String itemCategoryName) {
        System.out.println("Item Category searching by name '" + itemCategoryName + "' founded");
        return itemCategoryRepository.findByItemCategoryNameLike(itemCategoryName);
    }

    public ItemCategory saveItemCategory(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    public void deleteItemCategoryById(Long itemCategoryId) {
        itemCategoryRepository.deleteById(itemCategoryId);
    }

    public ItemCategory updateItemCategoryName(Long itemCategoryId, String itemCategoryName) {
        ItemCategory itemCategory = itemCategoryRepository.findById(itemCategoryId).get();
        itemCategory.setItemCategoryName(itemCategoryName);
        return itemCategoryRepository.save(itemCategory);
    }

    public ItemCategory updateItemCategoryDescription(Long itemCategoryId, String itemCategoryDescription) {
        ItemCategory itemCategory = itemCategoryRepository.findById(itemCategoryId).get();
        itemCategory.setItemCategoryDescription(itemCategoryDescription);
        return itemCategoryRepository.save(itemCategory);
    }

    public ItemCategory updateItemCategoryImage(Long itemCategoryId, String itemCategoryImage) {
        ItemCategory itemCategory = itemCategoryRepository.findById(itemCategoryId).get();
        itemCategory.setItemCategoryImage(itemCategoryImage);
        return itemCategoryRepository.save(itemCategory);
    }

}
