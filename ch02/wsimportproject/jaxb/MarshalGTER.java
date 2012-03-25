package jaxb;


import client2.*;

import javax.xml.bind.*;
import java.util.*;

/**
 * Creado por: jaime
 * 27/12/11
 */
public class MarshalGTER {

    public static void main(String[] args)throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(GetTimeAsElapsedResponse.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        GetTimeAsElapsedResponse getTimeAsElapsedResponse = new GetTimeAsElapsedResponse();
        getTimeAsElapsedResponse.setReturn(new Date().getTime());

        marshaller.marshal(getTimeAsElapsedResponse, System.out);
    }
}
