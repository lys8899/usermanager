package com.lys.usermanager;

import java.util.ArrayList;

/**
 * @description:
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-10-01 12:38
 **/
public class TTT {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        TTTT tttt = new TTTT("aaa", 1, 3L, objects);
        System.out.println(tttt);
        TTTT tttt1=new TTTT(tttt.getAaa(),tttt.getBbb(),tttt.getCccc(),tttt.getArrayLists());
        System.out.println(tttt);

    }


}

class TTTT {
    String aaa;
    Integer bbb;
    Long cccc;
    ArrayList<Object> arrayLists;

    public TTTT() {
    }

    public TTTT(String aaa, Integer bbb, Long cccc, ArrayList<Object> arrayLists) {
        this.aaa = aaa;
        this.bbb = bbb;
        this.cccc = cccc;
        this.arrayLists = arrayLists;
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public Integer getBbb() {
        return bbb;
    }

    public void setBbb(Integer bbb) {
        this.bbb = bbb;
    }

    public Long getCccc() {
        return cccc;
    }

    public void setCccc(Long cccc) {
        this.cccc = cccc;
    }

    public ArrayList<Object> getArrayLists() {
        return arrayLists;
    }

    public void setArrayLists(ArrayList<Object> arrayLists) {
        this.arrayLists = arrayLists;
    }

    @Override
    public String toString() {
        return "TTTT{" +
                "aaa='" + aaa + '\'' +
                ", bbb=" + bbb +
                ", cccc=" + cccc +
                ", arrayLists=" + arrayLists +
                '}';
    }
}
