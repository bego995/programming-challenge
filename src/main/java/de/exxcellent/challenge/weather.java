package de.exxcellent.challenge;

public class weather implements Iweather{
    int day = 0;
    int mxt = 0;
    int mnt = 0;

    @Override
    public int getSpread(int mxt, int mnt) {
        return mxt - mnt;
    }

    @Override
    public void fetchData() {

    }
}
