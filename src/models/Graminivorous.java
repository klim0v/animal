package models;


import exception.IllegaDieException;
import exception.IllegaVolumeException.IllegaMaxVolumeException;
import exception.IllegaVolumeException.IllegaMinVolumeException;


/**
 * Травоядное животное
 */
public class Graminivorous extends Animal {
    /**
     * Признак, живое или тушка
     */


    /**
     * Максимальное количество мяса, одинаково для всех
     */
    private static final int MAX_VOLUME = 1000;

    /**
     * Количество мяса
     */


    /**
     * Скорость поедания травы, для всех одинаковая
     */
    private static final int EAT_STEP = 30;

    /**
     * Конструктор
     */
    public Graminivorous(int weight, String name) {
        super(weight, name);
        if (weight >= MAX_VOLUME)
            throw new IllegaMaxVolumeException("Слишком большое животное");
        if (weight <= 0)
            throw new IllegaMinVolumeException("Слишком маленькое животное");
    }

    @Override
    public void eating(Eat eat) throws IllegalArgumentException {
        if (!alive)
            throw new IllegalArgumentException("мертвые не могут есть!");

        if (!(eat instanceof Grass))
            throw new IllegalArgumentException("травоядные едят только траву!");
        Grass g = (Grass) eat;

        int volume = g.giveFood(EAT_STEP);
        if (weight < MAX_VOLUME)
            weight += volume;
        weight = MAX_VOLUME > weight ? weight : MAX_VOLUME;
    }

    /**
     * Сдохнуть
     */
    public void die() throws IllegalAccessException {
        if (!alive)
            throw new IllegaDieException("он уже мертв!");
        alive = false;
    }

    /**
     * Наличие мяса
     *
     * @return истина, если еще есть, что сожрать
     */
    public boolean hasMeat() {
        return weight > 0;
    }


    /**
     * Отдать мяса
     *
     * @param foodVolume количество, которое пытаются откусить
     * @return сколько удалось откусить
     */
    public int giveFood(int foodVolume) {
        if (alive)
            return 0;

        if (weight > foodVolume) {
            weight -= foodVolume;
            return foodVolume;
        }

        int realVolume = weight;
        weight = 0;
        return realVolume;

    }

    @Override
    public String getGenus() {
        return "Травоядное";
    }

}
