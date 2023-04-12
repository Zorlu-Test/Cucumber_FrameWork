package com.Ensar.pages;

public class Pages {


    private DashBoard dashBoard;



    public DashBoard dashBoard() {
        if (dashBoard == null) {
            dashBoard = new DashBoard();
        }
        return dashBoard;
    }





}
