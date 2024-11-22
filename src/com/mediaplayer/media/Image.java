package com.mediaplayer.media;
import java.util.Scanner;

public class Image implements Playable{
    private String imageName;
    private int imageBrightness;

    public void createImage (Scanner scanner) {
        System.out.println("Come si chiama l'immagine?");
        this.imageName = scanner.nextLine();

        System.out.println("Inserisci luminosità dell'immagine (max: 10)");
        while (true) {
            this.imageBrightness = scanner.nextInt();
            scanner.nextLine();
            if (this.imageBrightness > 0 && this.imageBrightness <= 10) break;
            else System.out.println("La luminosità non può essere minore di 1 e non può superare 10. Riprova");
        }
        System.out.println("Immagine creata");
    }

    public void increaseBrightness(Scanner scanner) {
        System.out.println("Di quanto vuoi alzare la luminosità");
        while (true) {
            int increasedValue = scanner.nextInt();
            scanner.nextLine();
            this.imageBrightness+=increasedValue;
            if (this.imageBrightness > increasedValue && this.imageBrightness <= 10) break;
            else if (this.imageBrightness > increasedValue && this.imageBrightness > 10) this.imageBrightness = 10;
            else System.out.println("Per abbassare la luminosità seleziona la giusta opzione");
        }
    }

    public void decreaseBrightness(Scanner scanner) {
        System.out.println("Di quanto vuoi abbassare la luminosità?");
        int decreasedValue = scanner.nextInt();
        scanner.nextLine();
        this.imageBrightness-=decreasedValue;
        if (this.imageBrightness <= 0) this.imageBrightness = 0;
    }
    
    @Override
    public void play() {
        show();
    }

    public void show() {
        String brightnessValue = "";
        for (int i = 0; i < this.imageBrightness; i++) {
            brightnessValue = brightnessValue + "!";
        }
        System.out.println(this.imageName + brightnessValue );
    }
}
