package Utilities;

import java.math.BigDecimal;

import org.json.JSONObject;

public class Utilities {
	public static BigDecimal JsonParserGBP(String jsonResponse) {

		JSONObject obj = new JSONObject(jsonResponse);
		return obj.getJSONObject("data").getJSONObject("quote").getJSONObject("GBP")
				.getBigDecimal("price");
	}

	public static BigDecimal JsonParserD(String jsonResponse) {
		JSONObject obj = new JSONObject(jsonResponse);
		return obj.getJSONObject("data").getJSONObject("quote").getJSONObject("D")
				.getBigDecimal("price");
	}
}
