package fr.foxelia.buildingparcel.parcel;

public class ParcelRequierement {

    double money = 0;
    int level = 0;

    public ParcelRequierement(double money, int level) {
        this.money = money;
        this.level = level;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean match(double money, int level) {
        return this.money <= money && this.level <= level;
    }

}
