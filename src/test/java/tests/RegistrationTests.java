package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);

        //*************************************

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(z);

        User user = new User()
                .withFirstName("Lisa")
                .withLastName("Snow")
                .withEmail("snow" + z + "@gmail.com")
                .withPassword("Ssnow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }

    @Test
    public void registrationWrongEmail() {
        User user = new User().withEmail("domgmail.com").withPassword("Ddom123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Login or Password incorrect"));
    }
    @Test
    public void registrationWrongPassword() {
        User user = new User().withEmail("dom@gmail.com").withPassword("Ddom123");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Login or Password incorrect"));
    }

    @Test
    public void registrationExistUser() {
        User user = new User().withEmail("8witt8@gmail.com").withPassword("Felix88@ill99");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOKButton();
    }


}