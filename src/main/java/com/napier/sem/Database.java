package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class that creates DB connection
 */
public class Database {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets countries based on query
     * @return ArrayList of Countries
     */
    public ArrayList<Country> getCountries(String sql) {
        ArrayList<Country> countries = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Country c = new Country();
                c.country_code = rset.getString("country.Code");
                c.country_capital = rset.getString("country.Capital");
                c.country_population = rset.getInt("country.Population");
                c.country_name = rset.getString("country.Name");
                c.country_continent = rset.getString("country.Continent");
                c.country_region = rset.getString("country.Region");
                countries.add(c);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }

        return countries;

    }

    /**
     * Gets cities based on query
     * @return ArrayList of cities
     */
    public ArrayList<City> getCities(String sql) {
        ArrayList<City> cities = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                City c = new City();
                c.name = rset.getString("city.Name");
                c.country = rset.getString("country.Name");
                c.district = rset.getString("city.District");
                c.population = rset.getInt("city.Population");
                cities.add(c);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }

        return cities;

    }
}

