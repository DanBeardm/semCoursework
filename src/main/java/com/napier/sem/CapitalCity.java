package com.napier.sem;

public class CapitalCity {
    /**
     *  Name
     */
    public String city_name;

    /**
     *  Country
     */
    public String country_name;

    /**
     *  Population
     */
    public Integer city_population;

    @Override
    public String toString() {
        return (this.city_name + "\t"
                + this.country_name + "\t"
                + this.city_population+ "\t"
        );
    }
}
