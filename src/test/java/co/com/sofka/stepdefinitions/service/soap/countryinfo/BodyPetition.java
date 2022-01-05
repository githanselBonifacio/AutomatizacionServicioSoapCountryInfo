package co.com.sofka.stepdefinitions.service.soap.countryinfo;

import static co.com.sofka.util.FileUtilities.readFile;

public class BodyPetition {

    protected static String bodyRequest(String pathRequest, String code){
        return String.format(readFile(pathRequest),code);
    }
    protected static  String bodyResponse(String expectedResponse,String response){
        return String.format(expectedResponse,response);
    }
}
