package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Object SortUtil;

    public static void main(String[] args) {
        // Քայլ 1: Տվյալների հավաքում `weather.com` կայքից
        List<WeatherData> scrapedData = WeatherScraper.scrapeWeather();

        if (scrapedData.isEmpty()) {
            System.out.println("No data scraped. Please check the website and selectors.");
            return;
        }

        // Քայլ 2: Տվյալների ծառի կառուցում
        BinaryTree tree = new BinaryTree();
        for (WeatherData data : scrapedData) {
            tree.add(data);
        }

        System.out.println("\nAll Weather Data (Tree Structure):");
        tree.printAll(); // Տպում ենք բոլոր տվյալները ծառի միջոցով

        // Քայլ 3: Տվյալների սորտավորում
        System.out.println("\nSorted Weather Data (By Temperature):");
        List<WeatherData> dataList = new ArrayList<>(scrapedData); // Թողարկում ենք ցանկ
        SortUtil.insertionSort(dataList); // Սորտավորում ըստ ջերմա
