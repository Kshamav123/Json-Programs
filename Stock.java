package com.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Stock {
	public String name;
	public double noOfShares;
	public double sharePrice;

	public Stock(String name, double noOfShares, double sharePrice) {
		super();
		this.name = name;
		this.noOfShares = noOfShares;
		this.sharePrice = sharePrice;
	}

	

	@Override
	public String toString() {
		return "Stock [name=" + name + ", noOfShares=" + noOfShares + ", sharePrice=" + sharePrice + "]";
	}

}