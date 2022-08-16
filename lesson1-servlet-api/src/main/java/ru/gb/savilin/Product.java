package ru.gb.savilin;

public class Product {

    private long id;
    private String title;
    private int cost;

    Product(String title, int cost){
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }


}
