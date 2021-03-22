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
        // Create a new DB instance
        Database db = new Database();

        // Connect to database
        db.connect();

        //Display Countries
        //db.getCountriesWorldFromLargest();

        //Display City population
        //db.getCityPopulationWorld();
        //db.getCityPopulationContinent();
        //db.getCityPopulationRegion();
        //db.getCityPopulationCountry();
        //db.getCityPopulationDistrict();

        //Display Capital City Population
        //db.getCapCityPopulation();
        //db.getCapCityPopulationContinent();
        //db.getCapCityPopulationRegion();
        db.getCapCityPopSpec(5);

        // Disconnect from database
        db.disconnect();

    }
}