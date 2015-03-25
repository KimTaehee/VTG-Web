package com.videothegathering.parser;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VimeoURLParser {

	public String getVimeoMovieURL(String url) {

		// url로부터 vid 추출하기, string에서 vid 추출해서 변수에 저장하고 "vid", "여기"에 넘겨
		String num = null;

		Pattern pat = Pattern.compile("(?<=http:..vimeo.com.).*");

		Matcher mat = pat.matcher(url);

		if (mat.find()) {
			num = mat.group(0);
		}
		System.out.println(num);

		Document doc = null;
		Elements elements = null;
		String Tag = null;
		try {

			Connection conn = Jsoup
					.connect("http://player.vimeo.com/video/" + num + "/config")
					.data("autoplay", "0")
					.data("byline", "0")
					.data("bypass_privacy", "1")
					.data("context", "clip.main")
					.data("default_to_hd", "1")
					.data("portrait", "0")
					.data("title", "0")
					// request.
					.referrer("http://vimeo.com/" + num)
					.ignoreContentType(true)
					.userAgent(
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
					.timeout(5000); //
			Connection.Response resp = conn.execute();
			if (resp.statusCode() == 200) {
				doc = conn.get();
				elements = doc.select("body");

				String result = null;

				for (Element e : elements) {
					result = e.html();
				}
				
				System.out.println(result);
				Pattern pattern = Pattern
						.compile("(?<=\"sd\").*?(?=\",\"height\":)");
				// 추출할 내용.

				Matcher match = pattern.matcher(result);


				if (match.find()) {
					Tag = match.group(0);
				}

				pattern = Pattern.compile("http://.*");
				match = pattern.matcher(Tag);

				if (match.find()) {
					Tag = match.group(0);
				}
				System.out.println(Tag);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // post 요청

		return Tag;
	}
}
