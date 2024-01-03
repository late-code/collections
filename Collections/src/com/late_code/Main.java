package com.late_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian",8,12);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        pritnList(seatCopy);

        seatCopy.get(1).reserve();
        if (theatre.reverseSeat("A02")){
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reversed");
        }

        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
        pritnList(seatCopy);
        System.out.println("Priting theatre.seat");
        pritnList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
    }

    public static void pritnList(List<Theatre.Seat> list){
        for (Theatre.Seat seat: list){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("=".repeat(50));
        sortList(list);
    }

    public static void sortList(List< ? extends Theatre.Seat> list){
        for (int i = 1; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list,i,j);
                }
            }
        }
    }
}
