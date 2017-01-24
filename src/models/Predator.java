package models;


import exception.IllegaVolumeException.IllegaMaxVolumeException;
import exception.IllegaVolumeException.IllegaMinVolumeException;

/**
 * Хищник
 */
public class Predator extends Animal {
    /**
     * Максимальное количество мяса, одинаково для всех
     */
    private static final int MAX_VOLUME = 2000;

    private static final int EAT_STEP = 50;

    /**
     * Конструктор
     */
    public Predator(int weight, String name) {
        super(weight, name);
        if (weight >= MAX_VOLUME)
            throw new IllegaMaxVolumeException("Слишком большое животное");
        if (weight <= 0)
            throw new IllegaMinVolumeException("Слишком маленькое животное");
    }

    @Override
    public void eating(Eat eat) throws IllegalArgumentException, IllegalAccessException {
        if (!(eat instanceof Graminivorous))
            throw new IllegalArgumentException("хищники едят только травоядных!");

        Graminivorous g = (Graminivorous) eat;
        if (g.alive)
            kill(g);


        int volume = g.giveFood(EAT_STEP);

        //if (weight < MAX_VOLUME)
            weight += volume;
       // weight = MAX_VOLUME > weight ? weight : MAX_VOLUME;

    }

    public void kill(Graminivorous g) {
        try {
            g.die();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int giveFood(int foodVolume) {
        return 0;
    }

    @Override
    public String getGenus() {
        return "Хищник";
    }
}
