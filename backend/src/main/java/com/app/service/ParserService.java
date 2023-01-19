package com.app.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ParserService {
    private final String siteUrl = "https://www.leagueofgraphs.com/champions/builds/";
    private final String rankUrl = "/gold/sr-ranked";

    private Document getPageConnection(String role) throws IOException {
        return Jsoup.connect(siteUrl + role + rankUrl).followRedirects(false).timeout(60000).get();
    }

    public List<String> getChampionsByRole(String role) throws IOException {
        Document document = getPageConnection(role);
        return document.getElementsByClass("name").select("span").stream().map(Element::text).collect(Collectors.toList());
    }
}
