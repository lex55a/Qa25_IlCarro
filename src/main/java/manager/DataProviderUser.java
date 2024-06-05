package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"8witt8@gmail.com", "Felix88@ill99"});
        list.add(new Object[]{"elena.krylataya@gmail.com", "Lenakira11$"});
        list.add(new Object[]{"8witt8@gmail.com", "Felix88@ill99"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModels() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("8witt8@gmail.com").setPassword("Felix88@ill99")});
        list.add(new Object[]{new User().setEmail("elena.krylataya@gmail.com").setPassword("Lenakira11$")});
        list.add(new Object[]{new User().setEmail("8witt8@gmail.com").setPassword("Felix88@ill99")});
        return list.iterator();
    }

}
