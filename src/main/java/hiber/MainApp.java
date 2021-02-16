package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jws.soap.SOAPBinding;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      Car car2 = new Car("BMV", 57);
      User user2=new User("User2", "Lastname2", "user2@mail.ru");

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("Toyota",107)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("UAZ",0)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",new Car("Seo",29)));
      userService.add(new User("Vlad", "Silly", "silly@gmail.com",new Car("Toyota", 107)));
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car= " + user.getCar());
         System.out.println();
      }


      System.out.println(userService.findUserByModelAndSeries("Toyota", 107));

      System.out.println(userService.findUserByModelAndSeries("BMV", 66));

      context.close();
   }
}
