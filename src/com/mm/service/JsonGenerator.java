package com.mm.service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mm.dao.MapDetailsDao;

public class JsonGenerator {

	public void JsonGenerator(String[] slno,String[] url,String[] des) {
		//MapDetailsDao mapObj = new MapDetailsDao();
		JSONObject obj = getJsonMapDetails(slno,url,des);
		try {
			
			ResourceBundle bundle = ResourceBundle.getBundle("TopScoreAccess");
			String JsonPath = bundle.getString("FilePathJson");
			
			//FileWriter file = new FileWriter("C:\\Users\\yadumk\\Desktop\\WORKSPACE1\\Voting\\WebContent\\us-election\\img\\test.json");
			FileWriter file = new FileWriter(JsonPath);
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);

	}
	public JSONObject getJsonMapDetails(String[] slno, String[] url,
			String[] des) {
		JSONObject obj = new JSONObject();
		try {
			for (int i = 0; i <= slno.length; i++) {
				JSONArray list = new JSONArray();

				list.add(url[i]);
				list.add(des[i]);

				obj.put(i, list);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

		return obj;
	}

}
