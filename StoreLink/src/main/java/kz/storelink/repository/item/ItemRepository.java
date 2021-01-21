package kz.storelink.repository.item;

import kz.storelink.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    public static
    List<Item> findByName(String item_name);
//    @Query(value = "SELECT * FROM item i where ")

}
