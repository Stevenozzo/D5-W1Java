package com.mediaplayer.media;
import java.util.*;

public class Media {

    private List<Playable> mediaList;
    public String selection;

    public void createMediaList() {
        this.mediaList = new ArrayList<>();
    }

    public void scannerMedia (Scanner scanner) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Scrivi l'elemento multimediale che vuoi creare tra Audio, Video e Immagine");
            selection = scanner.nextLine().toLowerCase();
            switch(selection) {
                case "audio":
                    Audio audio = new Audio();
                    audio.createAudio(scanner);
                    addMedia(audio);
                    break;
                case "video":
                    Video video = new Video();
                    video.createVideo(scanner);
                    addMedia(video);
                    break;
                case "immagine":
                    Image image = new Image();
                    image.createImage(scanner);
                    addMedia(image);
                    break;
                default:
                    System.out.println("Tipo non valido. Riprova.");
                    i--;
                    break;
            }
        }
    }

    public void addMedia(Playable media) {
        mediaList.add(media);
    }

    public void playConfirm(Scanner scanner) {
        System.out.println("Quale file vuoi riprodurre?");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice >= 1 && choice <= mediaList.size()) {
            Playable selectedMedia = mediaList.get(choice - 1);

            if (selectedMedia instanceof Image) {
                ((Image) selectedMedia).show();
            } else {
                selectedMedia.play();
            }
        } else {
            System.out.println("Scelta non valida, riprova.");
        }
    }
}
