package com.sasan.linklist;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album=new Album("Stormbribger","Deep Purple");
        album.addSong("Stormbribger", 4.6f);
        album.addSong("Love", 3.6f);
        album.addSong("Hold", 5.6f);
        album.addSong("Lady", 3.6f);
        album.addSong("You ", 2.6f);
        album.addSong("High", 7.2f);
        album.addSong("SOldier", 3.16f);
        albums.add(album);

        album=new Album("For those about torock","Sasan");
        album.addSong("Track 01", 4.6f);
        album.addSong("Track 02", 3.6f);
        album.addSong("Track 03", 5.6f);
        album.addSong("Track 04", 3.6f);
        album.addSong("Track 05 ", 2.6f);
        album.addSong("Track 06", 7.2f);
        album.addSong("Track 07", 3.16f);
        albums.add(album);

        LinkedList<Song> playList=new LinkedList<>();
        albums.get(0).addToPlayList("Hold",playList);
        albums.get(0).addToPlayList("SOldier",playList);
        albums.get(0).addToPlayList("Lady",playList);
        albums.get(0).addToPlayList("Lady",playList);
        albums.get(0).addToPlayList(2,playList);
        albums.get(1).addToPlayList("Track 01",playList);
        albums.get(1).addToPlayList("Track 02",playList);
        albums.get(1).addToPlayList("Track 04",playList);
        albums.get(1).addToPlayList(7,playList);
        albums.get(1).addToPlayList(11,playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner=new Scanner(System.in);
        boolean quit=false;
        boolean forware=true;

        ListIterator<Song> listIterator=playList.listIterator();
        if(playList.size()==0){
            System.out.println("No songs in playlist");
        }else {
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action=scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("PlayList complete.");
                    quit=true;
                    break;
                case 1:
                    if(!forware){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forware=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else{
                        System.out.println("We have reached the end of the playlist");
                    }
                    break;
                case 2:
                    if(forware){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forware=true;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("We are at the strat of the playlist");
                        forware=true;
                    }
                    break;
                case 3:
                    if(forware){
                        if(listIterator.hasNext()){
                            System.out.println("Now Replaying "+listIterator.previous().toString());
                            forware=false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasPrevious()){
                            System.out.println("No3 Replaying "+listIterator.next().toString());
                            forware=true;
                        }else{
                            System.out.println("We have reached the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator=playList.iterator();
        System.out.println("=================================");
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    private static void printMenu() {
        System.out.println("0- to quit\n"+
                "1- to play next song\n"+
                "2- to play previous song\n"+
                "3- to replay the current song\n"+
                "4- list songs in the playlist\n"+
                "5- print available actions.\n"+
                "6- Remove current song frm playlist");
    }
}
