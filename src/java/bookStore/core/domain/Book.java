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
    
    private String title;
    private int authID;
    private String genre;
    private String ISBN;
    private String description;
    
    public Book(){
        
    }
    public Book(String title,
                int authID,
                String genre,
                String ISBN,
                String description)
    {
        this.title = title;
        this.description = description;
        this.authID = authID;
        this.genre = genre;
        this.ISBN = ISBN;
    }
}
