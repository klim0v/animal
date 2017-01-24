package models;


/**
 * Трава
 */
public class Grass implements Eat {

    protected int id;
    protected String name;
    protected int weight;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Максимальное количество травы, одинаково для всех
     */
    private static final int MAX_VOLUME = 500;

    /**
     * Текущее количество травы на участке
     */
    //private int volume;

    /**
     * Скорость роста травы на участке
     */
    private int growSpeed;

    /**
     * Конструктор
     */
    public Grass(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }


    /**
     * Рост травы
     */
    private void grow() {
        if (weight < MAX_VOLUME)
            weight += growSpeed;
        weight = MAX_VOLUME > weight ? weight : MAX_VOLUME;
    }

    /**
     * Кормить травоядное
     *
     * @param foodVolume сколько хочет сожрать
     * @return сколько удалось сожрать
     */

    public int giveFood(int foodVolume) {
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
        return "Травa";
    }


}

