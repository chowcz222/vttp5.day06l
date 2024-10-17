package appdata;

import java.util.*;
import java.util.stream.Collectors;
import  java.time.LocalDate;
import java.time.*;

public class App {

    public static void main(String[] args) {
        
    //     Thread th = new Thread(new Runnable() {

    //         public void run() {

    //             for(int i = 0; i < 10; i++) {
    //                 System.out.println(Thread.currentThread().getName() + " -> " +i);
    //             }
    //         }    
    //     });
    //     th.start();
    // }

        // MyImplementation my1 = new MyImplementation();
        // MyImplementation my2 = new MyImplementation();
        // MyImplementation my3 = new MyImplementation();
        // MyImplementation my4 = new MyImplementation();
        // MyImplementation my5 = new MyImplementation();

        // ExecutorService es = Executors.newSingleThreadExecutor();
        // es.execute(my1);
        // es.execute(my2);
        // es.shutdown();

        // ExecutorService es1 = Executors.newFixedThreadPool(5);
        // es1.execute(my1);
        // es1.execute(my2);
        // es1.execute(my3);
        // es1.execute(my4);
        // es1.execute(my5);
        // es1.shutdown();

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Apple Ipad", "Apple tablet", "computer"));
        products.add(new Product(2L, "Apple Macbook Pro", "Apple laptop", "computer"));
        products.add(new Product(3L, "Logitech Mouses", "Mouse", "computer"));
        products.add(new Product(4L, "32 inch Monitor", "Samsung monitor", "computer"));
        products.add(new Product(5L, "Huawei 3", "Huawei phone", "mobile"));
        products.add(new Product(6L, "Oppo 7 Pro", "Oppo phone", "mobile"));
        products.add(new Product(7L, "Galaxy 24", "Samsung phone", "mobile"));
        products.add(new Product(8L, "Apple 13", "Apple phone", "mobile"));

        products.forEach(prod -> {
            System.out.println(prod);
        });

        System.out.println("\n");

        // products.forEach(Product::toString);

        List<Product> filterProducts = new ArrayList<>();
        filterProducts = products.stream().filter(p-> p.getCategory().equals("mobile")).collect(Collectors.toList());
        filterProducts.forEach(Product::print);
        // filterProducts.forEach(prod -> {
        //     System.out.println(prod);
        // });
        System.out.println("\n");

        LocalDate ld = LocalDate.of(1990, 1, 12);
        Date currentDate = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<Person> persons = new LinkedList<>();
        persons.add(new Person(1L, "Bernard", "Tan", 30000.0, currentDate));
        persons.add(new Person(2L, "Chris", "Tan", 20000.0, currentDate));
        persons.add(new Person(3L, "Dennis", "Wong", 15000.0, currentDate));
        persons.add(new Person(4L, "Thomas", "Chia", 5000.0, currentDate));
        persons.add(new Person(5L, "Rick", "Ng", 35000.0, currentDate));
        persons.add(new Person(6L, "Micheal", "Choy", 12000.0, currentDate));
        persons.add(new Person(7L, "Darren", "Loh", 32000.0, currentDate));
        persons.add(new Person(8L, "May", "Tan", 20000.0, currentDate));

        Comparator<Person> compare = Comparator.comparing(p -> p.getFirstName());
        persons.sort(compare);
        persons.forEach(p -> {
            System.out.println(p.toString());
        });

        System.out.println("\n");

        //Sort all the similar firstname together, then sort all the ppl with both similar firstname and lastname together
        Comparator<Person> compareMultiple = Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName);
        persons.sort(compareMultiple);
        persons.forEach(p -> {
            System.out.println(p.toString());
        });


    }
}