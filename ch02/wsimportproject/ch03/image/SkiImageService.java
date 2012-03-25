package ch03.image;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.ImageReader;
import javax.jws.HandlerChain;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

@WebService(serviceName = "SkiImageService", wsdlLocation = "ch03/image/image.wsdl")
//@HandlerChain(file = "handler-chain.xml") // for message tracking
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class SkiImageService {
    // Returns one image given the image's name.
    @WebMethod
    public Image getImage(String name) {
        return createImage(name);
    }

    // Returns a list of all available images.
    @WebMethod
    public List<Image> getImages() {
        return createImageList();
    }

    public SkiImageService() {
        photos = new HashMap<String, String>();
        photos.put("nordic", "nordic.jpg");
        photos.put("alpine", "alpine.jpg");
        photos.put("telemk", "telemk.jpg");
        default_key = "nordic";
    }

    // Create a named image from the raw bytes.
    private Image createImage(String name) {
        byte[] bytes = getRawBytes(name);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        Iterator iterators = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader imageReader = (ImageReader) iterators.next();
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(in);
            imageReader.setInput(iis, true);
            return imageReader.read(0);
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    // Create a list of all available images.
    private List<Image> createImageList() {
        List<Image> list = new ArrayList<Image>();
        Set<String> key_set = photos.keySet();
        for (String key : key_set) {
            Image image = createImage(key);
            if (image != null) list.add(image);
        }
        return list;
    }

    // Read the bytes from the file for one image.
    private byte[] getRawBytes(String name) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            String base_name = "C:\\Users\\jaime\\Desktop\\SCDJWS\\resources\\jpegs\\";
            String file_name = base_name + name + ".jpg";
            FileInputStream in = new FileInputStream(file_name);

            // Send default image if there's none with this name.
//            if (in == null) in = new FileInputStream(base_name + "nordic.jpg");
            byte[] buffer = new byte[2048];
            int n = 0;
            while ((n = in.read(buffer)) != -1)
                out.write(buffer, 0, n); // append to ByteArrayOutputStream
            in.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        return out.toByteArray();
    }

    private static final String[] names = {
            "nordic.jpg", "tele.jpg", "alpine.jpg"};

    private Map<String, String> photos;
    private String default_key;
}

