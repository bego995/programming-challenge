package de.exxcellent.challenge;

/**
 * @author bilal ranko
 * weather class with corresponding fields. they are fetched by the utils class
 */
public class weather implements Iweather{
    int day = 0;
    int mxt = 0;
    int mnt = 0;

    @Override
    public int getSpread(int mxt, int mnt) {
        return mxt - mnt;
    }
}
