package ch03.image.client;


import java.awt.Image;
import java.util.List;

class SkiImageClient2 {
    public static void main(String[ ] args) {
       SkiImageService_Service service = new SkiImageService_Service();
       SkiImageService port = service.getSkiImageServicePort();

       Image image = port.getImage("telemk");
       List<Image> images = port.getImages();
        System.out.println(images);
       /* Process the images in some appropriate way. */
    }
}