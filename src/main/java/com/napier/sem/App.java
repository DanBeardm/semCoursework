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
        //db.getCountriesWorldFromLargest();
        //db.getCityPopulationWorld();
        db.getCityPopulationContinent();
        // Disconnect from database
        db.disconnect();

    }
}