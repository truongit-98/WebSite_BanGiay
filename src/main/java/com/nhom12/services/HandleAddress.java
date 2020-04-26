/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom12.services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nhom12.Database.Models.RootCity;
import com.nhom12.Database.Models.RootObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;

/**
 *
 * @author Truong98
 */
public class HandleAddress {
    public static String handleAddress(ServletContext context, String cityId, String districtId, String wardId) throws IOException {
        InputStream inputStream = null;
        String fileName = "xa-phuong/" + districtId + ".json";
        String content = "", address = "";
        StringBuffer buf = new StringBuffer();
        try {
            inputStream = context.getResourceAsStream("/resources/json/" + fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((content = bufferedReader.readLine()) != null) {
                buf.append(content).append("\n");
            }
            Map<String, RootObject> map = new Gson().fromJson(buf.toString(), new TypeToken<HashMap<String, RootObject>>() {
            }.getType());
            address += map.get(wardId).getNameWithType();

            inputStream = context.getResourceAsStream("/resources/json/quan-huyen/" + cityId + ".json");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            buf = new StringBuffer();
            content = "";
            while ((content = bufferedReader.readLine()) != null) {
                buf.append(content).append("\n");
            }
            map = new Gson().fromJson(buf.toString(), new TypeToken<HashMap<String, RootObject>>() {
            }.getType());
            address += ", " + map.get(districtId).getNameWithType();

            inputStream = context.getResourceAsStream("/resources/json/tinh_tp.json");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            buf = new StringBuffer();
            content = "";
            while ((content = bufferedReader.readLine()) != null) {
                buf.append(content).append("\n");
            }
            Map<String, RootCity> map1 = new Gson().fromJson(buf.toString(), new TypeToken<HashMap<String, RootCity>>() {
            }.getType());
            address += ", " + map1.get(cityId).getNameWithType();
        } catch (JsonSyntaxException | IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return address;
    }
}
