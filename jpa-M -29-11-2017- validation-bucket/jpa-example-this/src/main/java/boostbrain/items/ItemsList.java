package boostbrain.items;

import java.util.ArrayList;
import java.util.List;

public class ItemsList extends ArrayList<Item>{








    private List<Item> itemsToSell = new ArrayList<Item>();


    public List<Item> getItemsToSell() {
        return itemsToSell;
    }

    public void setItemsToSell(List<Item> itemsToSell) {
        this.itemsToSell = itemsToSell;
    }
}
