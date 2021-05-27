package kz.storelink.service.item;

import kz.storelink.model.item.Item;
import kz.storelink.model.item.ItemCategory;
import kz.storelink.model.user.User;
import kz.storelink.repository.item.ItemCategoryRepository;
import kz.storelink.repository.item.ItemRepository;
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
public class ItemService {

    private ItemRepository itemRepository;
    private ItemCategoryRepository itemCategoryRepository;
    private UserRepository userRepository;

    public List<Item> showAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long itemId) {
        Item item = itemRepository.findById(itemId).orElse(null);
        System.out.println("Item searching by id: " + item);
        return item;
    }

    public List<Item> getItemByName(String itemName) {
        return itemRepository.findByItemNameLike(itemName);
    }

    public Item saveItem(Item item) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.getUserByUsername(username);
        item.setUserId(user.getUserId());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        item.setCreatedDate(timestamp);
        return itemRepository.save(item);
    }

    public Item updateItem(Item item) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.getUserByUsername(username);
        if(item.getUserId().equals(user.getUserId())) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            item.setUpdatedDate(timestamp);
            itemRepository.save(item);
        } else {
            System.out.println("It is not your item!");
        }

        return item;
    }

    public void deleteItemById(Long itemId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Item item = itemRepository.findItemByItemId(itemId);
        String username = userDetails.getUsername();
        User user = userRepository.getUserByUsername(username);
        if(item.getUserId().equals(user.getUserId())) {
            itemRepository.deleteById(itemId);
        } else {
            System.out.println("It is not your item!");
        }
    }

    public ItemCategory assignItemCategory(Item item, ItemCategory itemCategory) {
        Set<Item> items = itemCategory.getItems();
        items.add(item);

        itemCategory.setItems(items);
        return itemCategoryRepository.save(itemCategory);
    }
    public ItemCategory unassignItemCategory(Item item, ItemCategory itemCategory) {
        Set<Item> items = itemCategory.getItems();
        items.remove(item);

        itemCategory.setItems(items);
        return itemCategoryRepository.save(itemCategory);
    }

}
