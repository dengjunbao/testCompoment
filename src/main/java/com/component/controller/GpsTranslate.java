/*package com.component.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


*//**
 * @author bao
 *//*
@RestController
@RequestMapping(value = "/api/gps")
public class GpsTranslate extends BaseController {

    @GetMapping(value = "/translateCallback")
    public String translateCallback(@RequestParam(value = "lng") String  lng,@RequestParam(value = "lat") String lat){
        String url = "http://api.map.baidu.com/ag/coord/convert?from=0&to=4&x=" + lng + "&y=" + lat;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        String XYstring = response.getBody().toString();
        return XYstring;
    }
}*/
