package models;

import java.io.Serializable;

/**
 * Created by c-0k on 08.09.2016.
 */
public interface Eat extends Serializable {

    public int getId();
    
    public String getName();

    public void setName(String name);

    public int getWeight();

    public void setWeight(int weight);

    public void setId(int id);

    public int giveFood(int foodVolume);

    public String getGenus();

}
