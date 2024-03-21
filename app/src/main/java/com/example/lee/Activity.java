package com.example.lee;

import java.util.ArrayList;

public class Activity {
    private static ArrayList<Activity>ActivityList = new ArrayList<>();
    private String id;
    private String Name;

    public Activity(String id, String name) {
        this.id = id;
        this.Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public static void initActivity(){
        Activity Activity1= new Activity("0", "Cricket");
        ActivityList.add(Activity1);

        Activity Activity2= new Activity("1", "Badminton");
        ActivityList.add(Activity2);

        Activity Activity3= new Activity("2", "Hockey");
        ActivityList.add(Activity3);

        Activity Activity4= new Activity("3", "ThrowBall");
        ActivityList.add(Activity4);

        Activity Activity5= new Activity("4", "Soccer");
        ActivityList.add(Activity5);

        Activity Activity6= new Activity("5", "VolleyBall");
        ActivityList.add(Activity6);
    }
    public int getImage(){
        switch (getId()){
            case "0":
                return R.drawable.cricket;
            case "1":
                return  R.drawable.badminton;
            case "2":
                return  R.drawable.hockey;
            case "3":
                return  R.drawable.throwball;
            case "4":
                return  R.drawable.soccer;
            case "5":
                return  R.drawable.volleyball;




        }
        return R.drawable.cricket;
    }
    public  static ArrayList<Activity> getActivityList() {
        return ActivityList;
    }
}
