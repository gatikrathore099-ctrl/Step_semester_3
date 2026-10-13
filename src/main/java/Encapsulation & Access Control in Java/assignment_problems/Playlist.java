import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full!");
        }
    }

    // Defensive copying: returns a fresh copy of the array containing only active songs
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs in copy: " + Arrays.toString(copy));

        // Attempting to modify the returned copy
        copy[0] = "Hacked";

        // Verification that original playlist internal state is untouched
        System.out.println("After modifying copy:");
        System.out.println("Copy array index 0: " + copy[0]);
        System.out.println("Playlist internal index 0: " + p.getSongs()[0]);
        System.out.println("getSongCount(): " + p.getSongCount());
    }
}