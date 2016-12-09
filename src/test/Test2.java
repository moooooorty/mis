package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import jdbc.entity.User;

public class Test2 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(date));
	}
}
