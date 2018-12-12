package org.bryan95.taekyulee;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class NetworkThread extends Thread{
    String keyword;
    String clientId = "bVJbuTdoQXghVoq82fFl";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "aYw8uFX0k3";//애플리케이션 클라이언트 시크릿값";
    ArrayList<FoodInfo> foodInfoArrayList;

    public NetworkThread(String keyword,ArrayList<FoodInfo> foodInfoArrayList){
        this.keyword=keyword;
        this.foodInfoArrayList=foodInfoArrayList;
    }

    @Override
    public void run() {

        try {
            String text = URLEncoder.encode(keyword, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/movie.xml?query="+text; // xml 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            InputStream is =con.getInputStream();
            // DOM  파서 생성
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(is);

            // 최상위 루트태그를 가져온다.
            Element root=document.getDocumentElement();
            // item 태그 객체들을 가져온다.
            NodeList item_list=root.getElementsByTagName("item");
            // 태그 개수만큼 반복한다.
            for(int i=0 ; i<item_list.getLength(); i++){
                // i 번째 태그 객체를 가져온다.
                Element item_tag=(Element)item_list.item(i);
                // item 태그 내의 title 과 link 를 가져온다.
                NodeList title_list=item_tag.getElementsByTagName("title");
                NodeList director_list=item_tag.getElementsByTagName("director");
                NodeList actor_list=item_tag.getElementsByTagName("actor");
               // NodeList userrating_list=item_tag.getElementsByTagName("userRating");

                Element title_tag = (Element)title_list.item(0);
                Element director_tag=(Element)director_list.item(0);
                Element actor_tag=(Element)actor_list.item(0);
               //Element userrating_tag=(Element)userrating_list.item(0);


                String title=title_tag.getTextContent();
                String director=director_tag.getTextContent();
                String actor=actor_tag.getTextContent();
                //Integer userRating=Integer.parseInt(userrating_tag.getTextContent());

                foodInfoArrayList.add(new FoodInfo(title,director,actor));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
