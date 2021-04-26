package com.napier.sem;

/**
 *  Population Schema
 */
public class Population {
    /**
     * Location Name / Language
     */
    public String target;

    /**
     * Population
     */
    public int population;


    @Override
    public String toString() {
        return (this.target + "\t | \t"
                + this.population+ "\t | \t");
    }
}
