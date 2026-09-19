package week7.assigment_problems;

import java.util.Arrays;

public class Playlist {

    private String[] songs;
    private int count;

    public Playlist(int size) {
        songs = new String[size];
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Songs: " + Arrays.toString(p.getSongs()));
        System.out.println("Song Count: " + p.getSongCount());
    }
}