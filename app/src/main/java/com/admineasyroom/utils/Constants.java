package com.admineasyroom.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Constants {

    public static String APPNODE="EasyRoomsApp";
    static String ROOMNODE="Rooms";
    public static String USERNODE="users";
    public static String FCMTOKEN="fcmToken";
    public static String FEEDBACKNODE="FeedBack";



    // Property Type Nodes
    public static String ROOMS="Rooms";
    public static String APARTMENTS="Apartments";
    public static String HOUSE="House";
    public static String OFFICEORRENTALSPACES="Office or Rental Spaces";
    public static String STORAGEUNIT="Storage Units";
    public static String FURNITURE="Furniture";
    public static String LAND="Land";
    public static String PARKINGSPACES="Parking Spaces";
    public static String NODE="node";



    public static DatabaseReference databaseReference(){
        return FirebaseDatabase.getInstance().getReference();
    }

}
