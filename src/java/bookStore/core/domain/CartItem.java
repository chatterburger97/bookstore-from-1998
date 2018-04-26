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
public class CartItem {
    private Book addedBook;
    private int qty = 0;
    
    public void setAddedBook(Book addedBook){
        this.addedBook = addedBook;
    }
    
    public void setQty(int qty){
        this.qty = qty;
    }

    public int getQty(){
        return qty;
    }
    public Book getAddedBook(){
        return addedBook;
    }
    
}
