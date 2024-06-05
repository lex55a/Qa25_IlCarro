package manager;

import models.Car;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderCars {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> carsSuccess() {
        int i = new Random().nextInt(1000)+1000;
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{
                Car.builder()
                        .location("Tel Aviv, Israel")
                        .manufacture("Mazda")
                        .model("M3")
                        .year("2023")
                        .fuel("Petrol")
                        .seats(4)
                        .carClass("C")
                        .carRegNumber("678-907-" +i)
                        .price(50)
                        .about("Very nice car")
                        .build()

        });
        list.add(new Object[]{
                Car.builder()
                        .location("Haifa, Israel")
                        .manufacture("BYD")
                        .model("A1")
                        .year("2024")
                        .fuel("Petrol")
                        .seats(5)
                        .carClass("A")
                        .carRegNumber("678-908-" +i)
                        .price(51)
                        .about("Super car")
                        .build()

        });

        return list.iterator();

}
}