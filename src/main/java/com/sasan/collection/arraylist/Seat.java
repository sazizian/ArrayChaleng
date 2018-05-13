package com.sasan.collection.arraylist;

public class Seat implements Comparable<Seat>{
    private final String seatNumber;
    private double price;
    private boolean reserved=false;


    public Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price=price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean reserve(){
        if(!this.reserved){
            this.reserved=true;
            System.out.println("Seat "+seatNumber+ " reserved");
            return true;
        }else{
            return false;
        }
    }

    public boolean cancel(){
        if(this.reserved){
            this.reserved=false;
            System.out.println("Reservation of seat "+ seatNumber+" canceled");
            return true;
        }else{
            return false;
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareTo(seat.getSeatNumber());
    }
}
