package base.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Lauren on 4/6/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/dbtest")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public ArrayList<Item> listAll() {
        ArrayList<Item> items = new ArrayList<Item>();
        for (Item item : itemRepository.findAll()) {
            items.add(item);
        }
        return items;
    }

    @GetMapping("{id}")
    public Item find(@PathVariable Long id) {
        return itemRepository.findOne(id);
    }

    @PostMapping
    public Item create(@RequestBody Item input) {
        return itemRepository
                .save(new Item(input.getWord()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        itemRepository.delete(id);
    }

    @PutMapping("{id}")
    public Item update(@PathVariable Long id, @RequestBody Item input) {
        Item course = itemRepository.findOne(id);
        if (course == null) {
            return null;
        } else {
            course.setWord(input.getWord());
            return itemRepository.save(course);
        }
    }
}
