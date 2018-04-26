/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.jdbc;

import bookStore.core.domain.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;

/**
 *
 * @author chatterburger
 */
public class BookDBHandler extends DBHandler {

    public ArrayList<Book> retrieveTopNBooks(int N) {
        ArrayList<Book> topNBooks = new ArrayList<>();
        System.out.println("entered retrieve db function");
        try {
            System.out.println("entered try block");
            if (makeConnection() == false) {
                System.out.println("connection to db failed");
                return topNBooks;
            }
            String sqlString = "SELECT [ID], [title], [author], [ISBN], [description], [genre] FROM [Books]";
            PreparedStatement pstmt = getConnection().prepareStatement(sqlString);
            //  pstmt.setInt(1, N);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int bookID = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String ISBN = rs.getString(4);
                String description = rs.getString(5);
                String genre = rs.getString(6);

                Book retrievedBook = new Book(bookID, title, author, ISBN, description, genre, 0);
                topNBooks.add(retrievedBook);

            }
        } catch (SQLException ex) {
            System.out.println("some error");
            Logger.getLogger(BookDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return topNBooks;
    }

    public ArrayList<Book> retrieveBooksByGenre(String genre) {

        ArrayList<Book> booksByGenre = new ArrayList<>();
        try {
            makeConnection();
            PreparedStatement pstmt = getConnection().prepareStatement("SELECT[ID], [title],[author],[ISBN],[description] FROM [Books] where [Genre]= ? ");
            pstmt.setString(1, genre);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // genre is already defined as all the books belong to the same genre
                int bookID = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String ISBN = rs.getString(4);
                String description = rs.getString(5);

                Book retrievedBook = new Book(bookID, title, author, genre, ISBN, description, 0);
                booksByGenre.add(retrievedBook);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return booksByGenre;
    }

    public Book retrieveBookByID(int ID) {
        Book retrievedBook = null;
        try {
            makeConnection();
            PreparedStatement pstmt = getConnection().prepareStatement("SELECT [title],[author],[ISBN],[description], [genre], [price] FROM [Books] where [ID]= ? ");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // genre is already defined as all the books belong to the same genre
                
                String title = rs.getString(1);
                String author = rs.getString(2);
                String ISBN = rs.getString(3);
                String description = rs.getString(4);
                String genre = rs.getString(5);
                int price = rs.getInt(6);
                retrievedBook = new Book(ID, title, author, genre, ISBN, description, price);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrievedBook;
    }

    private void createBook() {

    }

    private void updateBook(int bookID, Book newBook) {

    }

    private void deleteBook(int bookID) {
    }

    public boolean addNewBook(Connection con, String title, String author, String bn, String genre, String description) {
        if (con == null) {
            return false;
        }
        try {
            System.out.println(title);
            String sqlString = "INSERT INTO [Books]([title], [author], [isbn],[genre], [description]) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sqlString);
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, bn);
            pstmt.setString(4, genre);
            pstmt.setString(5, description);
            int executeUpdate = pstmt.executeUpdate();
            System.out.println("execute update updates some rows : " + executeUpdate);
            return (executeUpdate > 0);
        } catch (SQLException ex) {
            Logger.getLogger(BookDBHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception e) {
            System.out.println("exception");
            return false;
        }
    }

}
