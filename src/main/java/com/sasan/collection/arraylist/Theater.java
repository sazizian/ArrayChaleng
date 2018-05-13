package com.sasan.collection.arraylist;


import java.util.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Theater {
    private final String theaterName;
    private  List<Seat> seats=new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER=new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice()<seat2.getPrice()){
                return -1;
            }else if(seat1.getPrice()>seat2.getPrice()){
                return 1;
            }else{
                return 0;
            }
        }
    };

    static  final Comparator<Seat> PriCE_ORDER_LAMBDA=(s1,s2)->{
        if(s1.getPrice()>s2.getPrice())
            return 1;
        else if(s1.getPrice()==s2.getPrice()){
            return 0;
        }else
            return -1;

    };

    public Theater(String theaterName, int numbeRows, int seatsPerRow) {
        this.theaterName = theaterName;

        int lastRow='A'+(numbeRows-1);
        for(char row='A';row<=lastRow;row++){
            for(int seatNum=1; seatNum<=seatsPerRow;seatNum++){
                double price=12.00;
                if(row<'D' && (seatNum>=4 && seatNum<=9)){
                    price=14.00;
                }
                else if(row>'F' && (seatNum<4 || seatNum>9)){
                    price=7;
                }
                Seat seat=new Seat(row+String.format("%2d",seatNum),price);
                seats.add(seat);
            }
        }
    }
    public String getTheaterName() {
        return theaterName;
    }

    public boolean reservSeat(String seatNumber, double price){
        Seat requestSeat=new Seat(seatNumber, price);
        int foundSeat= Collections.binarySearch(seats,requestSeat,null);
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
//        for(Seat seat:seats){
//            if(seat.getSeatNumber().equals(seatNumber)){
//                requestSeat=seat;
//                break;
//            }
//        }
//        if(requestSeat==null){
//            System.out.println("There is no seat "+seatNumber);
//            return false;
//        }
//        return requestSeat.reserve();
    }
    //for testing
    public Collection<Seat> getSeats(){
        return seats;
    }
    public List<Seat> getSeat2(){
        return this.seats;
    }


}
