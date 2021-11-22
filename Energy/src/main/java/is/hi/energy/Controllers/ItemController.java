package is.hi.energy.Controllers;

import is.hi.energy.Persistence.Entities.Item;
import is.hi.energy.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @RequestMapping("/")
    public String itempage(Model model){
        List<Item> allItems = itemService.findAll();
        model.addAttribute("items", itemService.findAll());

        return "product";
    }

    @RequestMapping(value = "/additem/", method = RequestMethod.GET)
    public String addItem(Item item){
        return "newItem";
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addItem(Item item, BindingResult result, Model model){
        if(result.hasErrors()){
            return "newItem";
        }
        itemService.save(item);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable("id") long id, Model model){
        Item itemToDelete = itemService.findByID(id);
        itemService.delete(itemToDelete);
        return "redirect:/";
    }
}
