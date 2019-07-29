package com.timbuchalka;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String song, double duration){
        if(findSong(song) > -1){
            System.out.println("The sond already exists in this album");
            return false;
        }
        return songs.add(new Song(song, duration));

    }

    public int findSong(String song){
        for(int i=0; i<songs.size(); i++){
            if(song.equals(songs.get(i).getTitle()))
                return i;
        }
        return -1;
    }
    public void printSongs(){
        for(int i=0; i<songs.size(); i++){
            System.out.println("Song:  "+songs.get(i).getTitle()+ "\tDuration: "+ songs.get(i).getDuration());
        }
    }

    public boolean addToPlaylist (String song, LinkedList<Song> playlist){
        int pos = findSong(song);
        if(pos == -1){
            System.out.println("The song doesn't exist in this playlist");
            return false;
        }
        return playlist.add(songs.get(pos));
    }
    public boolean addToPlaylist (int track, LinkedList<Song> playlist){
        int pos= track -1;
        if(track < 0 || (pos>songs.size()) ){
            System.out.println("The song doesn't exist in this playlist");
            return false;
        }
        return playlist.add(songs.get(pos));
    }
    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
