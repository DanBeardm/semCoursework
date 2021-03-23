package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Main class of the Application
 */

public class App
{

    public static void main(String[] args)
    {
        //Create a new DB instance
        Database db = new Database();

        // Connect to database
        if(args.length < 1) {
            db.connect("0.0.0.0:49154");
        } else {
            db.connect(args[0]);
        }



        // Get user Input
        int n = OutputInput.getValue();


        // ********** Report Generation **********

        // All the countries in the world organised by largest population to smallest
        ArrayList<Country> r1 = db.getCountries(
                "SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC"
        );
        OutputInput.saveToFile(
                r1,
                "report1",
                "All the countries in the world organised by largest population to smallest"
        );

        // All the countries in a continent organised by largest population to smallest
        ArrayList<Country> r2 = db.getCountries(
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
                        "ORDER BY Continent, Population DESC"
        );
        OutputInput.saveToFile(
                r2,
                "report2",
                "All the countries in a continent organised by largest population to smallest"
        );

        // All the countries in a region organised by largest population to smallest
        ArrayList<Country> r3 = db.getCountries(
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
                        "ORDER BY Region, Population DESC"
        );
        OutputInput.saveToFile(
                r3,
                "report3",
                "All the countries in a region organised by largest population to smallest"
        );

        // The top N populated countries in the world where N is provided by the user
        ArrayList<Country> r4 = db.getCountries(
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
                        "ORDER BY Population " +
                        "DESC LIMIT " + n
        );
        OutputInput.saveToFile(
                r4,
                "report4",
                "The top N populated countries in the world where N is provided by the user"
        );

        // The top N populated countries in a continent where N is provided by the user
        ArrayList<Country> r5 = db.getCountries(
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
                        "WHERE Continent = 'Europe' " +
                        "ORDER BY Population DESC " +
                        "LIMIT " + n
        );

        OutputInput.saveToFile(
                r5,
                "report5",
                "The top N populated countries in a continent where N is provided by the user"
        );

        // The top N populated countries in a region where N is provided by the user
        ArrayList<Country> r6 = db.getCountries(
                "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
                        "WHERE Region = 'Eastern Europe' " +
                        "ORDER BY Population DESC " +
                        "LIMIT " + n
        );
        OutputInput.saveToFile(
                r6,
                "report6",
                "The top N populated countries in a region where N is provided by the user"
        );

        //All the cities in the world organised by largest population to smallest.
        ArrayList<City> r7 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "ORDER BY city.Population DESC"
        );
        OutputInput.saveToFile(
                r7,
                "report7",
                "All the cities in the world organised by largest population to smallest."
        );
        //All the cities in a continent organised by largest population to smallest.
        ArrayList<City> r8 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Continent = 'Europe' " +
                        "ORDER BY city.Population DESC "
        );
        OutputInput.saveToFile(
                r8,
                "report8",
                "All the cities in a continent organised by largest population to smallest"
        );
        //All the cities in a region organised by largest population to smallest.
        ArrayList<City> r9 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Continent = 'Eastern Europe' " +
                        "ORDER BY city.Population DESC"
        );
        OutputInput.saveToFile(
                r9,
                "report9",
                "All the cities in a region organised by largest population to smallest."
        );
        //All the cities in a country organised by largest population to smallest.
        ArrayList<City> r10 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Name = 'United Kingdom' " +
                        "ORDER BY city.Population DESC"
        );
        OutputInput.saveToFile(
                r10,
                "report10",
                "All the cities in a country organised by largest population to smallest."
        );
        //All the cities in a district organised by largest population to smallest.
        ArrayList<City> r11 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE city.District = 'Hlavní mesto Praha' " +
                        "ORDER BY city.Population DESC"
        );
        OutputInput.saveToFile(
                r11,
                "report11",
                "All the cities in a district organised by largest population to smallest."
        );
        //The top N populated cities in the world where N is provided by the user.
        ArrayList<City> r12 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
        OutputInput.saveToFile(
                r12,
                "report12",
                "The top N populated cities in the world where N is provided by the user"
        );

        //The top N populated cities in a continent where N is provided by the user.
        ArrayList<City> r13 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Continent = 'Europe' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
        OutputInput.saveToFile(
                r13,
                "report13",
                "The top N populated cities in a continent where N is provided by the user."
        );

        //The top N populated cities in a country where N is provided by the user.
        ArrayList<City> r14 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Name = 'United Kingdom' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
        OutputInput.saveToFile(
                r14,
                "report14",
                "The top N populated cities in a country where N is provided by the user."
        );

        //The top N populated cities in a district where N is provided by the user.
        ArrayList<City> r15 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE city.District = 'Hlavní mesto Praha' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
        OutputInput.saveToFile(
                r15,
                "report15",
                "The top N populated cities in a district where N is provided by the user."
        );
        //The top N populated cities in a region where N is provided by the user.
        ArrayList<City> r16 = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Region = 'Eastern Europe' " +
                        "ORDER BY city.Population DESC " +
                        "LIMIT " + n
        );
        OutputInput.saveToFile(
                r16,
                "report16",
                "The top N populated cities in a region where N is provided by the user."
        );


        // Disconnect from database
        db.disconnect();



    }


}