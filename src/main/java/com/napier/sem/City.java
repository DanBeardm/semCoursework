package com.napier.sem;

/**
 *  City Schema
 */
public class City {

    /**
     * City Name
     */
    public String name;

    /**
     * Country of the city
     */
    public String country;

    /**
     * City district
     */
    public String district;

    /**
     * Population
     */
    public int population;

    @Override
    public String toString() {
        return (this.name + "\t | \t"
                + this.country + "\t | \t"
                + this.district + "\t | \t"
                + this.population
        );
    }
}
