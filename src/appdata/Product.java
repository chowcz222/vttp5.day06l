package appdata;

public class Product {
    
    private long id;
    private String name;
    private String description;
    private String category;

    public Product(long id, String name, String description, String category) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }

    @Override 
    public String toString() {

        // return "Id: " + this.id + " Name: " + this.name + " Description: " + this.description + " Category: " + this.category;

        // csv format
        return String.valueOf(id) + ", " +name + ", " + description + ", " + category;
    }

    public void print() {
        System.out.println(toString());
    }
}
    

