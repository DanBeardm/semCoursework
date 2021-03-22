package com.napier.sem;

public class City {
    /**
     *  Code (PRIMARY KEY)
     */
    public Integer city_id;

    /**
     *  Name
     */
    public String city_name;

    /**
     *  Country
     */
    public String country_name;

    /**
     *  District
     */
    public String city_district;

    /**
     *  Population
     */
    public Integer city_population;

    @Override
    public String toString() {
        return (this.city_name + "\t"
                + this.country_name + "\t"
                + this.city_district + "\t"
                + this.city_population+ "\t"
        );
    }
}
