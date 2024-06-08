package com.springjwt.entities;
import java.util.ArrayList;

public class SeatMatrix {

    private String type;
    private Integer numRows;
    private Integer numCols;
    private int[][] Seats;
    private Integer basePrice;
    private Double windowSeatExtraPercentage;
    private Integer totalSeats;
    private Integer bookedSeats;
    private Integer maxChildrenPerAdult;

    public SeatMatrix(){
    }
    public SeatMatrix(String type, Integer numRows, Integer numCols, Integer basePrice, Double windowSeatExtraPercentage, Integer totalSeats, Integer bookedSeats, Integer maxChildrenPerAdult) {
        this.type = type;
        this.numRows = numRows;
        this.numCols = numCols;
        Seats = new int[numRows][numCols];

        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                Seats[i][j] = -1;
            }
        }


        this.basePrice = basePrice;
        this.windowSeatExtraPercentage = windowSeatExtraPercentage;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
        this.maxChildrenPerAdult = maxChildrenPerAdult;
    }
}
