package com.company;
import java.util.*;

public class Main extends SRC_DEST {

    static Map<SRC_DEST,Integer> mp=new HashMap<SRC_DEST,Integer>();

    static Set<Long> bookingIds=new HashSet<Long>();

    static Set<Long> PNRs=new HashSet<Long>();

    static Map<Long,Booked>status=new HashMap<Long,Booked>();

    public Main(){

    }

     public Main(String source,String destination){
        super(source,destination);
    }


    public SRC_DEST get_src_dst(){
        Scanner sc=new Scanner(System.in);
        // print line
        String source=sc.next();
        String destination=sc.next();
        Main user=new Main(source,destination);
        return user;
    }

    public void add_flight(SRC_DEST user){
        int price=0;
        System.out.println("Enter the price of the ticket");
        Scanner d=new Scanner(System.in);
        price=d.nextInt();
        mp.put(user,price);
        System.out.println("This Flight is successfully added");
    }

    public void remove_flight(SRC_DEST user){
        mp.remove(user);
        System.out.println("This Flight is successfully removed");
    }

    public void change_src(SRC_DEST user,String ss){
        int pr=mp.get(user);
        user.src=ss;
        mp.put(user,pr);
        System.out.println("Source station updated to "+ss);
    }

    public void change_dst(SRC_DEST user,String sss){
        int pr=mp.get(user);
        user.dst=sss;
        mp.put(user,pr);
        System.out.println("Destination station updated to "+sss);
    }

    public void change_price(SRC_DEST user,int price){
        mp.put(user,price);
        System.out.println("Price updated to "+price);
    }

    public void modify_flight(SRC_DEST user){
        System.out.println("Enter 7 for changing source, 8 for changing destination and 9 for changing flight price");
        Scanner c=new Scanner(System.in);
        int f=c.nextInt();
        switch(f){
            case 7:
                Scanner hg=new Scanner(System.in);
                String ss=hg.next();
                change_src(user,ss);
                break;
            case 8:
                Scanner hgg=new Scanner(System.in);
                String sss=hgg.next();
                change_dst(user,sss);
                break;
            case 9:
                Scanner hggg=new Scanner(System.in);
                int price=hggg.nextInt();
                change_price(user,price);
                break;
            default:
                break;
        }
    }

    public boolean flightAvailableOrNot(SRC_DEST user){
        //System.out.println(user.src+" "+ user.dst+" "+user.mp);
        if(mp.containsKey(user)){
            return true;
        }
        else{
            return false;
        }
    }


    public void Searching(SRC_DEST user){
        // SRC_DEST check=new Main();
        //System.out.println("user's src is "+ user.src);
        //user.func();
        //System.out.println("After user function called");
        //System.out.println(user==user.);
        if(flightAvailableOrNot(user)){
            System.out.println("This fight is available");
        }
        else{
            System.out.println("This Flight is not available");
        }

    }

    public long PNR_generator(){
        long leftLimit = 1L;
        long rightLimit = 1000000L;
        long generatedPNR= leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        if(PNRs.contains(generatedPNR)){
            return PNR_generator();
        }
        return generatedPNR;
    }

    public long ID_generator(){
        long leftLimit = 1L;
        long rightLimit = 1000000L;
        long generatedId= leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        if(bookingIds.contains(generatedId)){
            return ID_generator();
        }
        return generatedId;
    }


    public void Book(SRC_DEST user){
        if(flightAvailableOrNot(user)){
            // proceed booking
            int ticketPrice=mp.get(user);
            System.out.println("Ticket Price is "+ ticketPrice);
            long generatedId = ID_generator();
            long generatedPNR= PNR_generator();
            bookingIds.add(generatedId);
            PNRs.add(generatedPNR);
            Booked ticket=new Booked(generatedPNR, user.src, user.dst);
            status.put(generatedId,ticket);
            System.out.println("You ticket has been booked! and your Booking Id is "+ generatedId);
//            System.out.println(bookingIds+" \n"+PNRs);
//            System.out.println(status);
        }
        else{
            System.out.println("Sorry this flight is not available!!");
        }
    }


    public void Check_Status(){
//        System.out.println(bookingIds+" \n"+PNRs);
//        System.out.println(status);
        Scanner scn=new Scanner(System.in);
        long Id= scn.nextLong();
        if(status.containsKey(Id)){
            System.out.println("Your ticket from "+ status.get(Id).src + " to " +status.get(Id).dst+" and your pnr is "+status.get(Id).pnr);
        }
        else{
            System.out.println("No Booking done with this ID");
        }
    }

    public void print(){
        for(SRC_DEST key:mp.keySet()){
            System.out.println("Source: "+key.src +", Destination: " +key.dst +", Price: "+mp.get(key));
        }
    }


    public static void main(String[] args) {


        SRC_DEST obj1=new SRC_DEST("Chandigarh","Delhi");
        SRC_DEST obj2=new SRC_DEST("Chandigarh","Lucknow");
        SRC_DEST obj3=new SRC_DEST("Chandigarh","Jaipur");
        SRC_DEST obj4=new SRC_DEST("Mumbai","Delhi");
        SRC_DEST obj5=new SRC_DEST("Delhi","Chennai");
        SRC_DEST obj6=new SRC_DEST("Delhi","Bangalore");
        int cnt=0;
        mp.put(obj1,1000);
        mp.put(obj2,2000);
        mp.put(obj3,3000);
        mp.put(obj4,4000);
        mp.put(obj5,5000);
        mp.put(obj6,6000);

        System.out.println("enter ");

        System.out.println("Choose 1 for Searching Flights, 2 for Booking Flight ticket and 3 for Checking Booking Status and 4 for exit");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        do{
            switch(choice){
                case 1:
                    Main test=new Main();
                    test.Searching(test.get_src_dst());
                    break;
                case 2:
                    Main test2=new Main();
                    test2.Book(test2.get_src_dst());
                    break;
                case 3:
                    Main test3=new Main();
                    test3.Check_Status();
                    break;
                case 4:
                    Main test4=new Main();
                    test4.add_flight(test4.get_src_dst());
                    break;
                case 5:
                    Main test5=new Main();
                    test5.remove_flight(test5.get_src_dst());
                    break;
                case 6:
                    Main test6=new Main();
                    test6.modify_flight(test6.get_src_dst());
                    break;
                case 7:
                    Main test7=new Main();
                    test7.print();
                default:
                    break;
            }
            System.out.println("Choose 1 for Searching Flights, 2 for Booking Flight ticket and 3 for Checking Booking Status and 4 for exit");
            //Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
        }while(choice<=6);
        //System.out.println("after searching");
    }
}
