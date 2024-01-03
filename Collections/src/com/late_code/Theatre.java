package com.late_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {

    private final String theatreName;
    public List<Seat> seats = new ArrayList<>();


    public Theatre(String theatreName,int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + ( numRows - 1);
        for (char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                Seat seat = new Seat(row + String.format("%02d",seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName(){
        return theatreName;
    }

//    public boolean reverseSeat(String seatNumber){
//        Seat resquestedSeat = null;
//        for (Seat seat: seats){
//            System.out.print(".");
//             if (seat.getSeatNumber().equals(seatNumber)){
//                 resquestedSeat = seat;
//                 break;
//             }
//        }
//        if (resquestedSeat == null){
//            System.out.println("There is not seat " + seatNumber);
//            return false;
//        }
//        return resquestedSeat.reserve();
//    }

    public boolean reverseSeat(String seatNumber){
        Seat resquestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats,resquestedSeat,null);
        if (foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is not seat " + seatNumber);
            return false;
        }
    }
    // for testing
    public void getSeats(){
        for (Seat seat: seats){
            System.out.println(seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve(){
            if (!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel(){
            if (this.reserved){
                this.reserved = false;
                System.out.println("Revervation fo seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }

}
