package tests;

import manager.DataProviderCars;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{

@BeforeClass
public void preCondition() {
    if (!app.getHelperUser().isLogged()) {
        app.getHelperUser().login(new User()
                .setEmail("8witt8@gmail.com").setPassword("Felix88@ill99"));
    }
}


    @Test(dataProvider = "carsSuccess", dataProviderClass = DataProviderCars.class)
    public void addNewCarSuccessAll(Car car){
        int i = new Random().nextInt(1000)+1000;
        logger.info("Test start with test data --->" + car.toString());
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\KVAZAR\\Programming\\QA25\\Qa25_IlCarro\\2023-lamborghini-huracan.jpg");
        app.getHelperCar().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),car
                .getManufacture()+" "+car.getModel()+" added successful");
    }

    @Test
    public void addNewCarSuccess(){
        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-999-"+i)
                .price(50)
                .build();
        logger.info("Test start with test data --->" + car.toString());
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),car
                .getManufacture()+" "+car.getModel()+" added successful");



    }

    @AfterMethod
    public void postCondition(){
        app.getHelperCar().returnToHome();
    }

}
