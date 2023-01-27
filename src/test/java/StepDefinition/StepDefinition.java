package StepDefinition;

import static io.restassured.RestAssured.given;

import java.math.BigDecimal;
import java.util.function.Function;

import org.junit.runner.RunWith;

import Utilities.ParameterPojoClass;
import Utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;

@RunWith(Cucumber.class)
public class StepDefinition {
	Function<String, BigDecimal> refToFunction;
	ParameterPojoClass obj1;
	String response;
	public static BigDecimal currencyGBP;
	BigDecimal currencyDogeCoin;
	String response2;

	@Given("^All query parameters assigned to parameterPojoClass$")
	public void SetQueryParams() {
		RestAssured.baseURI = "https://pro-api.coinmarketcap.com";

		obj1 = new ParameterPojoClass();
		obj1.setAmount(10000000);
		obj1.setIdOne("3541");
		obj1.setConvertOne("GBP");
		obj1.setSourceURI("/v2/tools/price-conversion");
		obj1.setIdTwo("2791");
		obj1.setConvertTwo("DOGE");
	}

	@When("^User makes call to price-conversion api$")
	public void MakeApiCallGBP() {
		response = given().queryParam("amount", obj1.getAmount()).queryParam("id", obj1.getIdOne())
				.queryParam("convert", obj1.getConvertOne()).header("X-CMC_PRO_API_KEY", obj1.getApiKey())
				.header("Content-Type", "application/json").when().get(obj1.getSourceURI()).then().extract().response().asString();
	}

	@Then("^Input currency is changed to GBP currency$")
	public void GetConvertedCurrencyGBP() {
		refToFunction = Utilities::JsonParserGBP;
		currencyGBP = refToFunction.apply(response);
		System.out.println("Base currency was: Guatemalan Quetzal with amount: " + obj1.getAmount());
		System.out.println("Converted GBP are: " + currencyGBP);
	}

	@When("^User pass converted GBP to API$")
	public void MakeApiCallD() {
		response2 = given().queryParam("amount", currencyGBP).queryParam("id", obj1.getIdTwo())
				.queryParam("convert", obj1.getConvertTwo()).header("X-CMC_PRO_API_KEY", obj1.getApiKey())
				.header("Content-Type", "application/json").when().get(obj1.getSourceURI()).then().extract().response().asString();
	}

	@Then("GBP currency is changed to Dogecoin")
	public void GetConvertedCurrencyD() {
		refToFunction = Utilities::JsonParserD;
		currencyDogeCoin = refToFunction.apply(response2);
		System.out.println("Base currency was: GGBP with amount: " + currencyGBP);
		System.out.println("Converted Dogecoin are: " + currencyDogeCoin);
	}
	

}
