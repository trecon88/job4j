package ru.job4j.car;

/**
 * Класс машина.
 * @author contre
 * @since 08.09.2018
 * @version 1
 */
public class Car {
    /**
     * Contains gas volume.
     */
    private double volume;

    /**
     * Method drive.
     * @param kilometer - kilometers to drive.
     */
    public void drive(int kilometer) {
        this.volume = this.volume - kilometer;
    }

    /**
     * Method fill.
     * @param gas - amount of gas to fill.
     */
    public void fill(int gas) {
        this.volume = this.volume + 10 * gas;
    }

    /**
     * Method canDrive.
     * @return Может ли ехать или нет.
     */
    public boolean canDrive() {
        return this.volume > 0;
    }

    /**
     * Method gasInfo.
     */
    public void gasInfo() {
        System.out.println("I can drive " + this.volume + " kilometers.");
    }
}
