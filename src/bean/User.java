package bean;

public class User {
    private int id;
    private String name;
    private String email;
    private int discount;
    private int totalSum;

    public User(int id, String name, String email, int discount, int totalSum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.discount = discount;
        this.totalSum = totalSum;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getDiscount() {
        return discount;
    }

    public int getTotalSum() {
        return totalSum;
    }
}
