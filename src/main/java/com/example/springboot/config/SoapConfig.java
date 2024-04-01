package com.example.springboot.config;

import com.example.springboot.client.SoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.SpringBootSoap.wsdl");
        return marshaller;
    }

    @Bean
    public SoapClient getSoapClient(Jaxb2Marshaller marshaller){
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri("http://aplicacionesrv.df.local:365/Servicio.svc?WSDL");
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);
        return soapClient;
    }
}
