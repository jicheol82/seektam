package com.cjc.seektam.service.restaurant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cjc.seektam.dto.restaurant.KakaoMapDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class RestaurantServiceImple implements RestaurantService {

	@Override
	public List getRestaurantList(String locPosition) {
		String[] loc = locPosition.split("-");
		String addr = "https://dapi.kakao.com/v2/local/search/category.json?category_group_code=FD6&page=1&size=15&sort=accuracy&y=37.4812142&radius=500&x=126.9505233";
		String apiKey = "KakaoAK d9b8566f9f3e148cf330bf4b5b7b7777";
		String jsonString;
		List<KakaoMapDTO> result=null;
		Gson gson = new Gson();
		try {
			URL url = new URL(addr);
			URLConnection con = url.openConnection();
			con.setRequestProperty("Authorization", apiKey);
			BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			StringBuffer docJson = new StringBuffer();
			String line;
			while((line=rd.readLine()) != null) {
				docJson.append(line);
			}
			
			jsonString = docJson.toString();
			System.out.println(jsonString);
			result = gson.fromJson(jsonString, new TypeToken<List<KakaoMapDTO>>() {}.getType());
			rd.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void getRestaurantReputation() {
		// TODO Auto-generated method stub

	}

}
