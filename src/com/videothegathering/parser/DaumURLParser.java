package com.videothegathering.parser;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DaumURLParser {

	public String getDaumMovieURL(String url) {

		// url로부터 vid 추출하기, string에서 vid 추출해서 변수에 저장하고 "vid", "여기"에 넘겨
		String vid = null;
		
		Pattern pattern  =  Pattern.compile("(?<=http:..tvpot.daum.net.v.).*");
		
		Matcher match = pattern.matcher(url);
		 
		if(match.find()){ 
		    vid = match.group(0); 
		}
		System.out.println(vid);
		
		Document doc;
		Elements elements = null;
		
		try {
			doc = Jsoup.connect("http://videofarm.daum.net/controller/api/open/v1_2/MovieLocation.apixml")
					  // 요청 시 필요한 parameter 들 
					  .data("vid", vid)	// 
					  .data("profile", "MAIN")		// 
					  .data("play_loc", "tvpot")	// 

					  // and other hidden fields which are being passed in post request.
					  .userAgent("Mozilla")	// 

					  .get();
			
			elements = doc.select("url");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	// post 요청 

		
		String result = null;
		
		for(Element e:elements){
			result = e.text();
			
		}
		
		return result;
	}
}