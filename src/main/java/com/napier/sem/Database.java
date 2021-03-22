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
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets all the countries sorted from Largest
     * return A list of sorted countries
     */
    public void getCountriesWorldFromLargest()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital "
                                +"FROM country ORDER BY Population DESC "
                                +"LIMIT 10";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> countries = new ArrayList<>();
            while(rset.next()) {
                Country c = new Country();
                c.country_code = rset.getString("country.Code");
                c.country_name = rset.getString("country.Name");
                c.country_continent = rset.getString("country.Continent");
                c.country_region = rset.getString("country.Region");
                c.country_population = rset.getInt("country.Population");
                c.country_capital = rset.getString("country.Capital");

                countries.add(c);

            }

            for (Country c: countries) {
                System.out.println(c);
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }



    }

    public void getCityPopulationWorld()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.District, c1.Population "
                                + "FROM city c1 "
                                + "JOIN country ON country.Code = c1.CountryCode "
                                + "ORDER BY c1.Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cities = new ArrayList<>();
            while(rset.next()) {
                City c = new City();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_district = rset.getString("c1.District");
                c.city_population = rset.getInt("c1.Population");

                cities.add(c);
            }

            for (City c: cities) {
                System.out.println(c);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }

    public void getCityPopulationContinent()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.District, c1.Population "
                    + "FROM city c1 "
                    + "JOIN country ON country.Code = c1.CountryCode "
                    + "WHERE country.Continent = 'Europe' "
                    + "ORDER BY c1.Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cities = new ArrayList<>();
            while(rset.next()) {
                City c = new City();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_district = rset.getString("c1.District");
                c.city_population = rset.getInt("c1.Population");

                cities.add(c);
            }

            for (City c: cities) {
                System.out.println(c);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }

    public void getCityPopulationRegion()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.District, c1.Population "
                    + "FROM city c1 "
                    + "JOIN country ON country.Code = c1.CountryCode "
                    + "WHERE country.Region = 'North America' "
                    + "ORDER BY c1.Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cities = new ArrayList<>();
            while(rset.next()) {
                City c = new City();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_district = rset.getString("c1.District");
                c.city_population = rset.getInt("c1.Population");

                cities.add(c);
            }

            for (City c: cities) {
                System.out.println(c);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }

    public void getCityPopulationCountry()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.District, c1.Population "
                    + "FROM city c1 "
                    + "JOIN country ON country.Code = c1.CountryCode "
                    + "WHERE country.Name = 'United Kingdom' "
                    + "ORDER BY c1.Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cities = new ArrayList<>();
            while(rset.next()) {
                City c = new City();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_district = rset.getString("c1.District");
                c.city_population = rset.getInt("c1.Population");

                cities.add(c);
            }

            for (City c: cities) {
                System.out.println(c);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }

    public void getCityPopulationDistrict()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.District, c1.Population "
                    + "FROM city c1 "
                    + "JOIN country ON country.Code = c1.CountryCode "
                    + "WHERE c1.District = 'Scotland' "
                    + "ORDER BY c1.Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> cities = new ArrayList<>();
            while(rset.next()) {
                City c = new City();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_district = rset.getString("c1.District");
                c.city_population = rset.getInt("c1.Population");

                cities.add(c);
            }

            for (City c: cities) {
                System.out.println(c);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }

    public void getCapCityPopulation()
    {
        try{

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.Population "
                    + "FROM city c1 "
                    + "JOIN country ON country.Capital = c1.ID "
                    + "ORDER BY c1.Population DESC ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<CapitalCity> CapCities = new ArrayList<>();
            while(rset.next()) {
                CapitalCity c = new CapitalCity();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_population = rset.getInt("c1.Population");

                CapCities.add(c);
            }

            for (CapitalCity c: CapCities) {
                System.out.println(c);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }

    public void getCapCityPopulationContinent()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.Population "
                    + "FROM city c1 "
                    + "JOIN country ON country.Capital = c1.ID "
                    + "WHERE country.Continent = 'Europe' "
                    + "ORDER BY c1.Population DESC ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<CapitalCity> CapCities = new ArrayList<>();
            while (rset.next()) {
                CapitalCity c = new CapitalCity();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_population = rset.getInt("c1.Population");

                CapCities.add(c);
            }

            for (CapitalCity c : CapCities) {
                System.out.println(c);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }

    public void getCapCityPopulationRegion()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.Population "
                    + "FROM city c1 "
                    + "JOIN country ON country.Capital = c1.ID "
                    + "WHERE country.Region = 'Southern Europe' "
                    + "ORDER BY c1.Population DESC ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<CapitalCity> CapCities = new ArrayList<>();
            while (rset.next()) {
                CapitalCity c = new CapitalCity();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_population = rset.getInt("c1.Population");

                CapCities.add(c);
            }

            for (CapitalCity c : CapCities) {
                System.out.println(c);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }

    public void getCapCityPopSpec(Integer N)
    {
        System.out.println("Top " + N + " Populated Capital Cities");
        try{

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT c1.Name, country.Name, c1.Population "
                    + "FROM city c1 "
                    + "JOIN country ON country.Capital = c1.ID "
                    + "ORDER BY c1.Population DESC "
                    + "LIMIT " + N;


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<CapitalCity> CapCities = new ArrayList<>();
            while(rset.next()) {
                CapitalCity c = new CapitalCity();
                c.city_name = rset.getString("c1.Name");
                c.country_name = rset.getString("country.Name");
                c.city_population = rset.getInt("c1.Population");

                CapCities.add(c);
            }

            for (CapitalCity c: CapCities) {
                System.out.println(c);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed");
        }
    }
}
