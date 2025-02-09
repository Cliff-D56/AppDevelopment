package com.example.lib.Soccer;

import com.example.lib.League;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class Games {
    public static void main(String[] args) {
        Random rand = new Random();
        Team Tigers = new Team();
        Team Dogs = new Team();
        Team Cats = new Team();

        Player Cliff = new Player();
        Cliff.name = "Clifford";
        Cliff.age = 7;
        Player [] Roster = new Player[11];
        for(int i=0;i<11;i++){
            Roster[i]=Cliff;
        }
        Tigers.name = "Tigers";
        Tigers.players = Roster;
        Dogs.name = "Dogs";
        Dogs.players = Roster;
        Cats.name = "Cats";
        Cats.players = Roster;
        Tigers.rosterNum =1;
        Dogs.rosterNum =2;
        Cats.rosterNum = 3;
        for(int i =0;i<10;i++){
            ArrayList<Integer> league=new ArrayList<>();
            league.add(1);
            league.add(2);
            league.add(3);
            int firstRandRoster = league.get(rand.nextInt(league.size()));
            league.remove((Integer) firstRandRoster);
            int secondRandRoster =league.get(rand.nextInt(league.size()));
            ArrayList<Integer> match= new ArrayList<>();
            match.add(firstRandRoster);
            match.add(secondRandRoster);
            int winner = rand.nextInt(2);
            switch (match.get(winner)){
                case 1:
                    Tigers.wins++;
                    break;
                case 3:
                    Dogs.wins++;
                    break;
                case 2:
                    Cats.wins++;
                    break;
            }
//            System.out.println("The Winner is "+match.get(winner));
            match.remove(winner);
//            System.out.println("The loser is "+match.get(0));
            switch (match.get(0)){
                case 1:
                    Tigers.losses++;
                    break;
                case 3:
                    Dogs.losses++;
                    break;
                case 2:
                    Cats.losses++;
                    break;
            }
        }
        System.out.printf("The Tigers have won: %s Games %nThe Dogs have won %s Games %nThe Cats have won %s Games %n",Tigers.wins,Dogs.wins,Cats.wins);
        if(Tigers.wins> Dogs.wins && Tigers.wins > Cats.wins){
            System.out.printf("The Tigers have won the Soccer league with %s Wins and %s Losses",Tigers.wins,Tigers.losses);
        }
        if(Dogs.wins> Tigers.wins && Dogs.wins > Cats.wins){
            System.out.printf("The Dogs have won the Soccer league with %s Wins and %s Losses",Dogs.wins,Dogs.losses);
        }
        if(Cats.wins> Tigers.wins && Cats.wins > Dogs.wins){
            System.out.printf("The Cats have won the Soccer league with %s Wins and %s Losses",Cats.wins,Cats.losses);
        }
    }
}
