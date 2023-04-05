package cv09;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Animals.AbstractAnimal;
import Animals.Cat;
import Animals.Cow;
import Animals.Dog;
import Animals.Goat;
import Animals.Pig;
import ImplAnimal.Animal;
import ImplAnimal.CatImpl;
import ImplAnimal.CowImpl;
import ImplAnimal.DogImpl;
import ImplAnimal.GoatImpl;
import ImplAnimal.PigImpl;

public class App {

    public static void main(String[] args) {
        // company
        Employee E1 = new Employee("josef","a@first.com", "f1irst".toCharArray(), Employee.EmployeeType.ACTIVE );
        Employee E2 = new Employee("karel","gfirst.com", "f2irst".toCharArray(), Employee.EmployeeType.INACTIVE );
        Employee E3 = new Employee("melichar","h@first.com", "fi3rst".toCharArray(), Employee.EmployeeType.ACTIVE );
        Employee E4 = new Employee("jirka","c@first.com", "f4irst".toCharArray(), Employee.EmployeeType.INACTIVE );
        Employee E5 = new Employee("arnost","z@first.com", "f5irst".toCharArray(), Employee.EmployeeType.ACTIVE );
        Secretarian S1 = new Secretarian("simona", "1@second.com", "se1cond".toCharArray(), Employee.EmployeeType.ACTIVE, 43);
        Secretarian S2 = new Secretarian("david", "2@second.com", "se2cond".toCharArray(), Employee.EmployeeType.INACTIVE, 56);
        List<Employee> EList = Arrays.asList(E1,E2,E3,E4,E5);
        Manager<Secretarian> M = new Manager<>("ursula","1@manager.com", "manager".toCharArray(), Employee.EmployeeType.ACTIVE);
        Collections.sort(EList);
        for (Employee employee : EList) {
            System.out.println(employee.getEmail());}
        M.addListOfEmployees(EList);
        M.addRelationship(S1);
        M.printAllEmployeesAndRelationships();

        
        System.out.println("");
        AbstractAnimal cat = new Cat();
        AbstractAnimal dog = new Dog();
        AbstractAnimal pig = new Pig();
        AbstractAnimal cow = new Cow();
        AbstractAnimal goat = new Goat();
        System.out.println("Absract class: ");
        System.out.println("Cat: " + cat.sound());
        System.out.println("Dog: " + dog.sound());
        System.out.println("Pig: " + pig.sound());
        System.out.println("Cow: " + cow.sound());
        System.out.println("Goat: " + goat.sound());
        System.out.println("");
        
        
        Animal catimpl = new CatImpl();
        Animal dogimpl = new DogImpl();
        Animal pigimpl = new PigImpl();
        Animal cowimpl = new CowImpl();
        Animal goatimpl = new GoatImpl();
        System.out.println("Interface:");
        System.out.println("Cat: " + catimpl.sound());
        System.out.println("Dog: " + dogimpl.sound());
        System.out.println("Pig: " + pigimpl.sound());
        System.out.println("Cow: " + cowimpl.sound());
        System.out.println("Goat: " + goatimpl.sound());
        
        
    }
}