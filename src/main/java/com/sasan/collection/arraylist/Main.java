package com.sasan.collection.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theater theater=new Theater("Kermanshah theater", 8,12);
     //   theater.getSeats();
        List<Seat> seatCopy=new ArrayList<>(theater.getSeats());
        System.out.println(seatCopy.size());

        List<Seat> s=new ArrayList<>(theater.getSeat2());

        System.out.println(s.size());
        Collections.copy(s, seatCopy);



        printList(seatCopy);
        Collections.shuffle(seatCopy);
        System.out.println("===================================");
        System.out.println("==========================================================");
       // printList(seatCopy);

//        List<Seat> priceList=new ArrayList<>();
//        priceList.add(new Seat("B00",12));
//        priceList.add(new Seat("A00",11));
        Collections.sort(seatCopy, Theater.PRICE_ORDER);
        printList(seatCopy);


    }

    public static void printList(List<Seat> list){

        list.stream().forEach(seat->{
            System.out.print(seat.getSeatNumber()+" $"+seat.getPrice()+"  ***  ");
        });

    }
}
