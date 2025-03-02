package app.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static Connection connection = null;

    public Database () {
        connect();
    }

    private static void connect() {
        if (connection != null) {
            return;
        }
    
        try {
            String dbPath = "movies.db";  // Ensure this is the correct path
            System.out.println("Connecting to database: " + new java.io.File(dbPath).getAbsolutePath());
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
    

    public static ResultSet getMovies(int page, int number_of_movies) {
        Database.connect();
        
        String query = """
            SELECT * FROM "movies" LIMIT ? OFFSET ?;
        """;
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, number_of_movies);
            statement.setInt(2, (page - 1) * number_of_movies);

            return statement.executeQuery();

        } catch (SQLException e) {
            System.err.println("Fetching Error: " + e.getMessage());
        }

        return null;
    }

    public static void close () {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Close Error: " + e.getMessage());
            }
        }
    }
}
