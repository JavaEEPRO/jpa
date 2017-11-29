package boostbrain;

import boostbrain.items.Item;
import boostbrain.items.ItemsList;
import boostbrain.model.UserEntity;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BoostBrain on 24.02.2017.
 */

@Stateless
public class ExampleEJB {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    private ItemsList itemsList;

    public boolean checkPassword(String login, String password){
        if(StringUtils.isEmpty(login) || StringUtils.isEmpty(password)){
            return false;
        }

        UserEntity userEntity = entityManager.find(UserEntity.class, login);
        if(userEntity == null){
            return false;
        }

        if(password.equals(userEntity.getPassword())){
            return true;
        }

        return false;
    }

    public boolean createUser(String login, String password){
        if(StringUtils.isEmpty(login) || StringUtils.isEmpty(password)){
            return false;
        }

        UserEntity userEntity = entityManager.find(UserEntity.class, login);
        if(userEntity != null){
            return false;
        }

        userEntity = new UserEntity();
        userEntity.setLogin(login);
        userEntity.setPassword(password);
        entityManager.persist(userEntity);

        return true;
    }

    public List<UserEntity> getAllUsers(){
        Query query = entityManager.createQuery("select entity from UserEntity entity");
        return query.getResultList();
    }

    public List<Item> getGoods(){
        Query query = entityManager.createQuery("select entity from Item entity");
        return query.getResultList();
    }

    public void addTestItemToList() {
        List<Item> list = new ArrayList<Item>();
        list.add(new Item("toster", "d"));
        itemsList.setItemsToSell(list);}


    public boolean addGood(String name, String price) {

        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(price+"")){
            return false;
        }

        Item item = entityManager.find(Item.class, name);
        if(item != null){
            return false;
        }

        item = new Item();
        item.setName(name);
        item.setPrice(price);
        entityManager.persist(item);

        return true;
    }
}
