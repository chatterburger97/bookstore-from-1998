/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.domain;

/**
 *
 * @author chatterburger
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private String description;
    private int price;
    private int quantity ;
    
    public Book(){
        
    }
    public Book(int id, String title, String author, String genre, String ISBN, String description, int price, int quantity)
    {
        this.price = price;
        this.id = id;
        this.title = title;
        this.description = description;
        this.author= author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getGenre(){
        return genre;
    }
    public int getPrice(){
        return price;
    }
    public String getISBN(){
        return ISBN;
    }
    public String getDescription(){
        return description;
    }
    public int getQuantity(){
        return quantity;
    }
    /* setters */
    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    public void setQty(int newQty){
        this.quantity = newQty;
    }
}
