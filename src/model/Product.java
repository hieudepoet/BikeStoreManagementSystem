package model;

public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private String brand_name;
    private String category_name;
    private int model_year;
    private double list_price;
    private String status;

    public Product() {
        
    }

    public Product(String id, String name, String brand_name, String category_name, int model_year, double list_price) {
        this.id = id;
        this.name = name;
        this.brand_name = brand_name;
        this.category_name = category_name;
        this.model_year = model_year;
        this.list_price = list_price;        
    }
    
    public Product(String id, String name, String brand_name, String category_name, int model_year, double list_price, String status) {
        this.id = id;
        this.name = name;
        this.brand_name = brand_name;
        this.category_name = category_name;
        this.model_year = model_year;
        this.list_price = list_price;        
        this.status = status;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand_name() {
        return brand_name;
    }
    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public int getModel_year() {
        return model_year;
    }
    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }
    public double getList_price() {
        return list_price;
    }
    public void setList_price(double list_price) {
        this.list_price = list_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public int compareTo(Product temp) {
        int priceCompare = Double.compare(temp.list_price, this.list_price);
        if (priceCompare != 0)
            return priceCompare;
        return this.name.compareTo(temp.name);
    }

    @Override
    public String toString() {
        return getId() + ", " +
               getName() + ", " +
               getBrand_name() + ", " + 
               getCategory_name() + ", " + 
               getModel_year() + ", " +
               getList_price() + ", " +
               getStatus();
    }

    @Override
    public boolean equals(Object temp){
        if (this == temp) return true;
        if (temp == null || getClass() != temp.getClass()) return false; 
        Product product = (Product) temp;
        return this.id.equals(product.id);
    }
}
