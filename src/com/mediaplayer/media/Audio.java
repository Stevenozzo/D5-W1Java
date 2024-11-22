package com.mediaplayer.media;
import java.util.Scanner;

public class Audio implements Playable {
    private String audioName;
    private int audioDuration;
    private int audioVolume;

    public void createAudio (Scanner scanner) {
        System.out.println("Come si chiama l'audio?");
        this.audioName = scanner.nextLine();

        System.out.println("Inserisci durata dell'audio in minuti");
        while (true) {
            this.audioDuration = scanner.nextInt();
            scanner.nextLine();
            if (this.audioDuration >= 0) break;
            else System.out.println("La durata non può essere minore di 0. Riprova");
        }

        System.out.println("Inserisci volume (max: 10)");
        while (true) {
            this.audioVolume = scanner.nextInt();
            scanner.nextLine();
            if (this.audioVolume >= 0 && this.audioVolume <= 10) break;
            else System.out.println("Il volume non può essere minore di 0 e non può superare 10. Riprova");
        }
        System.out.println("Audio creato");
    }

    public void increaseVolume(Scanner scanner) {
        System.out.println("Di quanto vuoi alzare il volume?");
        while (true) {
            int increasedValue = scanner.nextInt();
            scanner.nextLine();
            this.audioVolume+=increasedValue;
            if (this.audioVolume > increasedValue && this.audioVolume <= 10) break;
            else if (this.audioVolume > increasedValue && this.audioVolume > 10) this.audioVolume = 10;
            else System.out.println("Per abbassare il volume seleziona la giusta opzione");
        }
    }

    public void decreaseVolume(Scanner scanner) {
        System.out.println("Di quanto vuoi abbassare il volume?");
            int decreasedValue = scanner.nextInt();
            scanner.nextLine();
            this.audioVolume-=decreasedValue;
            if (this.audioVolume <= 0) this.audioVolume = 0;
    }

    public void play() {
        String volumeValue = "";
        for (int i = 0; i < this.audioVolume; i++) {
            volumeValue = volumeValue + "!";
        }
        for (int i = 0; i < this.audioDuration; i++) {
            System.out.println(this.audioName + volumeValue );
        }
    }
}
