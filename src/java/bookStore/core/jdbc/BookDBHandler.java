/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.jdbc;

import bookStore.core.domain.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;

/**
 *
 * @author chatterburger
 */
public class BookDBHandler extends DBHandler {

    private void createBook() {

    }

    private ArrayList<Book> retrieveTopNBooks(int N) {

        ArrayList<Book> topNBooks = new ArrayList<>();
        try {
            makeConnection();
            String sqlString = "SELECT [title], [authorID], [ISBN], [description], [genre] FROM [Books] ORDER BY [title] LIMIT ?";
            PreparedStatement pstmt = getConnection().prepareStatement(sqlString);
            pstmt.setInt(1, N);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String title = rs.getString(1);
                int authorID = rs.getInt(2);
                String ISBN = rs.getString(3);
                String description = rs.getString(4);
                String genre = rs.getString(5);

                Book retrievedBook = new Book(title, authorID, ISBN, description, genre);
                topNBooks.add(retrievedBook);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return topNBooks;
    }

    private ArrayList<Book> retrieveBooksByGenre(String genre) {
        
        ArrayList<Book> booksByGenre = new ArrayList<>();
        try {
            makeConnection();
            PreparedStatement pstmt = getConnection().prepareStatement("SELECT [title],[authorID],[ISBN],[description] FROM [Books] where [Genre]= ? ");
            pstmt.setString(1, genre);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // genre is already defined as all the books belong to the same genre
                String title = rs.getString(1);
                int authorID = rs.getInt(2);
                String ISBN = rs.getString(3);
                String description = rs.getString(4);

                Book retrievedBook = new Book(title, authorID, genre, ISBN, description);
                booksByGenre.add(retrievedBook);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return booksByGenre;
    }

    private void updateBook(int bookID, Book newBook) {

    }

    private void deleteBook(int bookID) {

    }

}
