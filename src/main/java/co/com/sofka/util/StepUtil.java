package co.com.sofka.util;

import co.com.sofka.util.service.soap.countryinfo.Patch;
import co.com.sofka.util.service.soap.countryinfo.Response;

import static co.com.sofka.util.FileUtilities.readFile;

public class StepUtil {

    public static String bodyRequest(String pathRequest,String code){
        return String.format(readFile(pathRequest),code);
    }
    public static  String bodyResponse(String expectedResponse,String response){
        return String.format(expectedResponse,response);
    }
}
