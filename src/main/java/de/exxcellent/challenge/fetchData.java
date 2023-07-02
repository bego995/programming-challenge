package de.exxcellent.challenge;

import java.util.List;

public class fetchData implements IfetchData{
    IfetchData fetchData;

    public fetchData(IfetchData fd){
        this.fetchData = fd;
    }
    @Override
    public <T> List<T> getData(String filePath) {
        return null;
    }
}
