package ch03.image.client2;


import javax.activation.DataHandler;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingProvider;
import java.awt.*;
import java.io.IOException;
import java.util.List;

class SkiImageClient {
    public static void main(String[] args) {
        ch03.image.client2.SkiImageService_Service service = new ch03.image.client2.SkiImageService_Service();
        SkiImageService port = service.getSkiImageServicePort();
        javax.xml.ws.soap.SOAPBinding binding = (javax.xml.ws.soap.SOAPBinding) ((BindingProvider) port).getBinding();
        binding.setMTOMEnabled(true        );

        DataHandler image = port.getImage("nordic");
        dump(image);

        List<DataHandler> images = port.getImages();
        for (DataHandler hd : images)
            dump(hd);


        /* Process the images in some appropriate way. */
    }

    private static void dump(DataHandler dh) {
        System.out.println();
        try {
            System.out.println("MIME type: " + dh.getContentType());
            System.out.println("Content:   " + dh.getContent());
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}