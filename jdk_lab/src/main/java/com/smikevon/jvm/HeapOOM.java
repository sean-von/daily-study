package com.smikevon.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengxiao on 15-1-4.
 */
public class HeapOOM {

    static class OOMObject{
    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }

}
