package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Booked {
    public String src;
    public String dst;
    public Long pnr;

    public Booked(){

    }

    public Booked(Long PNR, String sr, String ds){
        src=sr;
        dst=ds;
        pnr=PNR;
    }

//    public boolean equals(Object obj)
//    {
//        SRC_DEST other= (SRC_DEST) obj;
//        return this.src.equals(other.src) && this.dst.equals(other.dst);
//    }

//    Set<Long> bookingIds=new HashSet<Long>();
//
//    Set<Long> PNRs=new HashSet<Long>();
//
//    Map<Long,Booked>status=new HashMap<Long,Booked>();

}
