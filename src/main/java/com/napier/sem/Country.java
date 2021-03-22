package com.napier.sem;

//`Code` char(3) NOT NULL DEFAULT '',
//        `Name` char(52) NOT NULL DEFAULT '',
//        `Continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') NOT NULL DEFAULT 'Asia',
//        `Region` char(26) NOT NULL DEFAULT '',
//        `SurfaceArea` decimal(10,2) NOT NULL DEFAULT '0.00',
//        `IndepYear` smallint DEFAULT NULL,
//        `Population` int NOT NULL DEFAULT '0',
//        `LifeExpectancy` decimal(3,1) DEFAULT NULL,
//        `GNP` decimal(10,2) DEFAULT NULL,
//        `GNPOld` decimal(10,2) DEFAULT NULL,
//        `LocalName` char(45) NOT NULL DEFAULT '',
//        `GovernmentForm` char(45) NOT NULL DEFAULT '',
//        `HeadOfState` char(60) DEFAULT NULL,
//        `Capital` int DEFAULT NULL,
//        `Code2` char(2) NOT NULL DEFAULT '',
//        PRIMARY KEY (`Code`)

/**
 *  Country schema
 */
public class Country {

    /**
     *  Code (PRIMARY KEY)
     */
    public String country_code;

    /**
     *  Name
     */
    public String country_name;

    /**
     *  Continent (PRIMARY KEY)
     */
    public String country_continent;

    /**
     *  Region (PRIMARY KEY)
     */
    public String country_region;

    /**
     *   Surface
     */
    public double country_surface;

    /**
     *   Independence
     */
    public int country_independence;

    /**
     *   Population
     */
    public int country_population;

    /**
     *   Life expectancy
     */
    public double country_life_expectancy;

    /**
     *   Gross Domestic Product
     */
    public double country_gnp;

    /**
     *   Gross Domestic Product Old
     */
    public double country_gnp_old;

    /**
     *   Local Name
     */
    public String local_name;

    /**
     *   Government Form
     */
    public String country_government;

    /**
     *   Head of state
     */
    public String country_head_of_state;

    /**
     *   Capital
     */
    public String country_capital;

    /**
     *   Code 2
     */
    public String country_code2;

    @Override
    public String toString() {
        return (this.country_code + "\t"
                + this.country_name + "\t"
                + this.country_continent + "\t"
                + this.country_region + "\t"
                + this.country_population + "\t"
                + this.country_capital + "\t"
        );
    }
}
