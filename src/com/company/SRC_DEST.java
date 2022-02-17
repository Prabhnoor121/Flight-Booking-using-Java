package com.company;
import java.util.*;

public class SRC_DEST {
    public String src="";
    public String dst="";
    //private int price=0;

    public SRC_DEST(){

    }

    public SRC_DEST(String x,String y){
        src=x;
        dst=y;
        //price=this.price;
    }

    public int hashCode(){
        int hash=0;
        hash=this.src.length() * this.src.length() * this.dst.length();
        hash+=this.dst.length();
        hash-=this.src.length();
        hash=hash*(this.src.charAt(0)-'a')*(this.dst.charAt(0)-'a');
        hash=hash+(this.src.charAt(this.src.length()-1)-'a')+(this.dst.charAt(this.dst.length()-1)-'a');
        return hash;
    }

    public boolean equals(Object obj)
    {
        SRC_DEST other= (SRC_DEST) obj;
        return this.src.equals(other.src) && this.dst.equals(other.dst);
    }

         //integer for PRICE
    //Map<,Integer> booked=new HashMap<SRC_DEST,Integer>();     // INteger for pnr


    public void func(){
//        SRC_DEST obj1=new SRC_DEST("Chandigarh","Delhi");
//        SRC_DEST obj2=new SRC_DEST("Chandigarh","Lucknow");
//        SRC_DEST obj3=new SRC_DEST("Chandigarh","Jaipur");
//        SRC_DEST obj4=new SRC_DEST("Mumbai","Delhi");
//        SRC_DEST obj5=new SRC_DEST("Delhi","Chennai");
//        SRC_DEST obj6=new SRC_DEST("Delhi","Bangalore");
//        int cnt=0;
//        mp.put(obj1,1000);
//        mp.put(obj2,2000);
//        mp.put(obj3,3000);
//        mp.put(obj4,4000);
//        mp.put(obj5,5000);
//        mp.put(obj6,6000);
        //System.out.println("all objects created");
        //System.out.println(mp);
    }

}

