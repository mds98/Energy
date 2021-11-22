package is.hi.energy.Services.Implementation;

import is.hi.energy.Persistence.Entities.Item;
import is.hi.energy.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImplementation implements ItemService {
    private List<Item>itemRepository = new ArrayList<>();
    private int id_counter = 0;

    @Autowired
    public ItemServiceImplementation() {
        //Create 3 random items for our dummy repo. To be removed when JPA added
        itemRepository.add(new Item("Mango Loco", "Mango flavour 500ml", "Monster", 4.5, 199, 160 ));
        itemRepository.add(new Item("Herbal Tea", "40 pieces in one pack", "tea company", 3.5, 1000, 30 ));
        itemRepository.add(new Item("c4 ultimate", "30 servings, blueberry flavour", "gym snack", 5.0, 6500, 250 ));

        //JPA gives each item an ID, but here we add them manually
        for(Item i: itemRepository){
            i.setID(id_counter);
            id_counter++;
        }
    }

    @Override
    public Item findByName(String name) {
        for(Item i:itemRepository){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    @Override
    public Item findByManufacturer(String manufacturer) {
        for(Item i:itemRepository){
            if(i.getManufacturer().equals(manufacturer)){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository;
    }

    @Override
    public Item findByID(long ID) {
        for(Item i: itemRepository){
            if(i.getID()==ID);{
                return i;
            }
        }
        return null;
    }

    @Override
    public Item save(Item item) {
        item.setID(id_counter);
        id_counter++;
        itemRepository.add(item);
        return item;
    }

    @Override
    public void delete(Item item) {
        itemRepository.remove(item);
    }
}
