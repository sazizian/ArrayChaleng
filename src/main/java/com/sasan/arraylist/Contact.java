package com.sasan.arraylist;

public class Contact {
    private String name;
    private long telNumber;

    public Contact(String name, long telNumber) {

        this.name = name;
        this.telNumber = telNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(long telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", telNumber=" + telNumber +
                '}';
    }
}
