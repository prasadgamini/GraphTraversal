package edu.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private Queue<String> queue;
    private List<String> discoveredLinks;

    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.discoveredLinks = new ArrayList<>();
    }

    public void discoverWeb(String root) {
        queue.add(root);
        discoveredLinks.add(root);

        while (!queue.isEmpty()) {
            String link = queue.remove();

            Matcher matcher  = Pattern.compile("https://(\\w+\\.)*(\\w+)").matcher(readURL(link));
            while(matcher.find()){
                String neighborURL = matcher.group();
                if(!discoveredLinks.contains(neighborURL)) {
                    discoveredLinks.add(neighborURL);
                    queue.add(neighborURL);
                    System.out.println("Website has been found : " + neighborURL);
                }
            }
        }
    }

    private String readURL(String link) {
        StringBuffer contentBuffer = new StringBuffer();
        try {
            URL url = new URL(link);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    contentBuffer.append(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contentBuffer.toString();
    }
}
