package appdata;

import java.util.*;
import java.util.stream.Collectors;

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

    }
}