
package models;


/**
 * Класс животного
 */
public abstract class Animal implements Eat {
    protected int id;
    protected String name;
    protected int weight;
    protected boolean alive;

    public Animal(int weight, String name) {

        this.weight = weight;
        this.name = name;
        alive = true;
    }

    public abstract void eating(Eat eat) throws Exception;

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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override

    public int getId() {
        return id;
    }
}
