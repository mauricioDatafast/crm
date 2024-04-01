package com.example.springboot.client;

import com.example.SpringBootSoap.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.List;

public class SoapClient extends WebServiceGatewaySupport {

    // CerrarRUC
    public String cerrarAfiliacionRuc(String ruc) {
        CerrarAfiliacionRUC request = new CerrarAfiliacionRUC();
        request.setRuc(crearJAXBElement(ruc));
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/IServicio.CerrarAfiliacionRUC");
        CerrarAfiliacionRUCResponse response = (CerrarAfiliacionRUCResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://aplicacionesrv.df.local:365/Servicio.svc",
                        request, soapActionCallback
                        );
        return response.getCerrarAfiliacionRUCResult().getValue();
    }

    private JAXBElement<String> crearJAXBElement(String ruc) {
        return new JAXBElement<String>(new QName("http://tempuri.org/", "ruc"),
                String.class, ruc);
    }

    // Listar todos los continentes
//    public List<TContinent> getAllContinents() {
//
//        ListOfContinentsByName listOfContinentsByName = new ListOfContinentsByName();
//        SoapActionCallback soapActionCallback = new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo");
//        ListOfContinentsByNameResponse response = (ListOfContinentsByNameResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",
//                        listOfContinentsByName, soapActionCallback);
//        return response.getListOfContinentsByNameResult().getTContinent();
//    }
//
//    // Listar todos los paises
//    public List<TCountryCodeAndName> getAllCountries() {
//
//        ListOfCountryNamesByCode listOfContinentsByName = new ListOfCountryNamesByCode();
//        SoapActionCallback soapActionCallback = new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo");
//        ListOfCountryNamesByCodeResponse response = (ListOfCountryNamesByCodeResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",
//                        listOfContinentsByName,
//                        soapActionCallback);
//        return response.getListOfCountryNamesByCodeResult().getTCountryCodeAndName();
//    }
//
//    // Listar las monedas por cada pais
//    public List<TCurrency> getAllCurrenciesByName() {
//
//        ListOfCurrenciesByName listOfCurrenciesByName = new ListOfCurrenciesByName();
//        SoapActionCallback soapActionCallback = new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo");
//        ListOfCurrenciesByNameResponse response = (ListOfCurrenciesByNameResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",
//                        listOfCurrenciesByName, soapActionCallback);
//        return response.getListOfCurrenciesByNameResult().getTCurrency();
//    }
//
//    // Buscar la moneda de un solo pais
//    public String getCurrencyByName(String code) {
//
//        CurrencyName currencyName = new CurrencyName();
//        currencyName.setSCurrencyISOCode(code);
//
//        SoapActionCallback soapActionCallback = new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo");
//
//        CurrencyNameResponse response = (CurrencyNameResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",
//                        currencyName, soapActionCallback);
//        return response.getCurrencyNameResult();
//    }
//
//    // Buscar un solo paios
//    public String findCountry(String code) {
//
//        CountryName countryName = new CountryName();
//        countryName.setSCountryISOCode(code);
//
//        SoapActionCallback soapActionCallback = new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo");
//
//        CountryNameResponse response = (CountryNameResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",
//                        countryName, soapActionCallback);
//        return response.getCountryNameResult();
//    }
}
