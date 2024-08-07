package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final String USER_AGENT = "Mozilla/5.0"; //사용자 정보
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // 사용자 검색 입력
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 옷을 입력하세요: ");
        String query = scanner.nextLine();
        scanner.close();

        // 쇼핑몰 API
        List<String> apiUrls = new ArrayList<>();
        apiUrls.add("https://" + query); //URL넣기

        //쇼핑몰 API에 요청
        for (String url : apiUrls) {
            try {
                String jsonResponse = sendGET(url);
                parseAndDisplayResults(jsonResponse);
            } catch (Exception e) {
                logger.error("오류" + url);
            }
        }
    }

    //GET 요청
    private static String sendGET(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    //응답 및 결과 출력
    private static void parseAndDisplayResults(String jsonResponse) {
        JSONObject obj = new JSONObject(jsonResponse);
        JSONArray results = obj.getJSONArray("검색"); //

        for (int i = 0; i < results.length(); i++) {
            JSONObject item = results.getJSONObject(i);
            String name = item.getString("이름");
            double price = item.getDouble("가격");
            String url = item.getString("url");

            System.out.println("이름: " + name);
            System.out.println("가격: " + price);
            System.out.println("URL: " + url);
            System.out.println();
        }
    }
}