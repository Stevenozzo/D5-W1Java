package com.mediaplayer.main;
import java.util.Scanner;
import com.mediaplayer.media.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Media media = new Media();
        media.createMediaList();
        media.scannerMedia(scanner);
        media.playConfirm(scanner);

        scanner.close();
    }
}
