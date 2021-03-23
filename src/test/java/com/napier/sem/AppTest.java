package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static Database db;

    @BeforeAll
    static void init()
    {
        db = new Database();
    }

    @Test
    void saveCountryReport()
    {
        ArrayList<Country> countryList = new ArrayList<Country>();
        Country c = new Country();
        c.country_region = "Test Region";
        c.country_name = "Test Name";
        c.country_continent = "Test Continent";
        c.country_code = "Test Code";
        c.country_capital = "Test Capital";
        c.country_population = 123456;

        countryList.add(c);

        OutputInput.saveToFile(countryList, "testCountryReport", "Test Country Report");
    }

    @Test
    void saveCityReport()
    {
        ArrayList<City> cityList = new ArrayList<City>();
        City c = new City();
        c.population = 123;
        c.district = "Test District";
        c.country = "Test Country";
        c.name = "Test Name";

        cityList.add(c);

        OutputInput.saveToFile(cityList, "testCityReport", "Test Country Report");
    }



}