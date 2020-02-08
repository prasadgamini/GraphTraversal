package edu.webcrawler;

public class Application {

    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();

        crawler.discoverWeb("http://www.bbc.com");

    }
}
