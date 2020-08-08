/*
 * The MIT License
 *
 * Copyright 2017 TrungKenbi.
 *
 */
package army2.server;

import java.util.ArrayList;
//import java.sql.ResultSet;
//import java.sql.SQLException;


public class ClanManager {
    
    public static class ClanEntry {
        int id;
        int master;
        String name;
        int icon;
        String thongBao;
        String item;
        int xu;
        int luong;
        int xp;
        int cup;
        int mem;
        int memMax;
        int level;
        String dateCreat;
        
    }
    
    public static class ClanMemEntry {
        int id;
        int user;
        int clan;
        String timeJoin;
        int xu;
        int luong;
        int cup;
        
    }
    
    public static ArrayList<ClanMemEntry> member;
    public static ArrayList<ClanEntry> entrys;
    public static ArrayList<ClanEntry> topTeam;
    
    public static final ClanMemEntry[] getMember(int page) {
        ArrayList<ClanMemEntry> mem = member;
        int index = page*10, lent = 0;
        if(index < mem.size())
            lent = (mem.size()-index)>10?10:(mem.size()-index);
        ClanMemEntry[] memberA = new ClanMemEntry[lent];
        for(int i = 0; i < lent; i++)
            memberA[i] = mem.get(index+i);
        return memberA;
    }
    
    public static final ClanEntry[] getTopTeam(int page) {
        refreshTopTeam();
        ArrayList<ClanEntry> bxh = topTeam;
        int index = page*10, lent = 0;
        if(index < bxh.size())
            lent = (bxh.size()-index)>10?10:(bxh.size()-index);
        ClanEntry[] bxhA = new ClanEntry[lent];
        for(int i = 0; i < lent; i++)
            bxhA[i] = bxh.get(index+i);
        return bxhA;
    }
    
    public static void getAllClan(int clan, int idmem) {
        /*try {
            int i = 0;
            ResultSet red = SQLManager.stat.executeQuery("SELECT * FROM `clan`;");
            if((red != null) && red.first()) {
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }*/
    }
    
    public static void refreshTopTeam() {
        /*
        //topTeam.clear();
        ArrayList<ClanEntry> topTeam1 = topTeam;
        try {
            int i = 0;
            ResultSet red = SQLManager.stat.executeQuery("SELECT * FROM `clan` LIMIT 0, 100;");
            while(red.next()) {
                
                int id = red.getInt("id");
                int master = red.getInt("master");
                String name = red.getString("name");
                int icon = red.getInt("icon");
                String thongBao = red.getString("thongBao");
                String item = red.getString("item");
                int xu = red.getInt("xu");
                int luong = red.getInt("luong");
                int xp = red.getInt("xp");
                int cup = red.getInt("cup");
                int mem = red.getInt("mem");
                int memMax = red.getInt("memmax");
                int level = red.getInt("level");
                String dateCreat = red.getString("dateCreat");
                
                ClanEntry bXHE = new ClanEntry();
                bXHE.id = id;
                bXHE.master = master;
                bXHE.name = name;
                bXHE.icon = icon;
                bXHE.thongBao = thongBao;
                bXHE.item = item;
                bXHE.xu = xu;
                bXHE.luong = luong;
                bXHE.xp = xp;
                bXHE.cup = cup;
                bXHE.mem = mem;
                bXHE.memMax = memMax;
                bXHE.level = level;
                bXHE.dateCreat = dateCreat;
                
                topTeam1.add(bXHE);
                i++;
            }
            red.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }*/
    }
    
    public static void addClanEntry(ClanEntry mEntry) {
    /*    ClanEntry mDatE = null;
        for(ClanEntry mDatE1 : entrys) {
            if(mDatE1.id == id) {
                mDatE = mDatE1;
                break;
            }
        }
        if(mDatE == null) {
            mDatE = new MissDataEntry();
            mDatE.id = id;
            mDatE.idNeed = idneed;
            mDatE.entrys = new ArrayList<>();
            entrys.add(mDatE);
        }*/
    }
    
    public static ClanEntry getClanData(int index) {
        /*for(ClanEntry mDatE1 : entrys) {
            for(MissionEntry me : mDatE1.entrys) {
                if(me.index == index)
                    return me;
            }
        }*/
        return null;
    }
    
}
