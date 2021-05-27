package kz.storelink.repository.item;

import kz.storelink.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNameLike(String itemName);

    Item findItemByItemId(Long itemId);

    @Query(value = "select i.* from item i, item_category_items iti, item_category it " +
            "where i.item_id = iti.items_item_id " +
            "and it.item_category_id=iti.item_category_item_category_id " +
            "and it.item_category_id = ?1;", nativeQuery = true)
    List<Item> findItemByItemCategoryId(Long itemCategoryId);

}
