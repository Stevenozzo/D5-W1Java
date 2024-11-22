package com.mediaplayer.media;
import java.util.Scanner;

public class Video implements Playable{
    private String videoName;
    private int videoDuration;
    private int videoVolume;
    private int videoBrightness;

    public void createVideo (Scanner scanner) {
        System.out.println("Come si chiama il video?");
        this.videoName = scanner.nextLine();

        System.out.println("Inserisci durata del video in minuti");
        while (true) {
            this.videoDuration = scanner.nextInt();
            scanner.nextLine();
            if (this.videoDuration >= 0) break;
            else System.out.println("La durata non può essere minore di 0. Riprova");
        }

        System.out.println("Inserisci luminosità del video (max: 10)");
        while (true) {
            this.videoBrightness = scanner.nextInt();
            scanner.nextLine();
            if (this.videoBrightness > 0 && this.videoBrightness <= 10) break;
            else System.out.println("La luminosità non può essere minore di 1 e non può superare 10. Riprova");
        }

        System.out.println("Inserisci volume (max: 10)");
        while (true) {
            this.videoVolume = scanner.nextInt();
            scanner.nextLine();
            if (this.videoVolume >= 0 && this.videoVolume <= 10) break;
            else System.out.println("Il volume non può essere minore di 0 e non può superare 10. Riprova");
        }
        System.out.println("Video creato");
    }

    public void increaseBrightness(Scanner scanner) {
        System.out.println("Di quanto vuoi alzare la luminosità?");
        while (true) {
            int increasedValue = scanner.nextInt();
            scanner.nextLine();
            this.videoBrightness+=increasedValue;
            if (this.videoBrightness > increasedValue && this.videoBrightness <= 10) break;
            else if (this.videoBrightness > increasedValue && this.videoBrightness > 10) this.videoBrightness = 10;
            else System.out.println("Per abbassare la luminosità seleziona la giusta opzione");
        }
    }

    public void decreaseBrightness(Scanner scanner) {
        System.out.println("Di quanto vuoi abbassare la luminosità?");
        int decreasedValue = scanner.nextInt();
        scanner.nextLine();
        this.videoBrightness-=decreasedValue;
        if (this.videoBrightness <= 0) this.videoBrightness = 0;
    }

    public void play() {
        String volumeValue = "";
        String brightnessValue = "";
        for (int i = 0; i < this.videoVolume; i++) {
            volumeValue = volumeValue + "!";
        }
        for (int i = 0; i < this.videoBrightness; i++) {
            brightnessValue = brightnessValue + "*";
        }
        for (int i = 0; i < this.videoDuration; i++) {
            System.out.println(this.videoName + volumeValue + brightnessValue );
        }
    }
}






