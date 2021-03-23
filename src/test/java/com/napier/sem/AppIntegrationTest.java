package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static Database db;

    @BeforeAll
    static void init()
    {
        db = new Database();
        db.connect("0.0.0.0:49154");

    }

    @Test
    void getCountry()
    {
        ArrayList<Country> countryList = db.getCountries(
                "SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC"
        );

        Country firstCountry = countryList.get(0);

        assertEquals(firstCountry.country_name, "China");

    }

    @Test
    void getCity()
    {
        ArrayList<City> cityList = db.getCities(
                "SELECT city.Name, city.Population, city.District, country.Name " +
                        "FROM city " +
                        "INNER JOIN country ON city.CountryCode = country.Code " +
                        "WHERE country.Continent = 'Europe' " +
                        "ORDER BY city.Population DESC "
        );

        City firstCity = cityList.get(0);

        assertEquals(firstCity.name, "Moscow");

    }
}