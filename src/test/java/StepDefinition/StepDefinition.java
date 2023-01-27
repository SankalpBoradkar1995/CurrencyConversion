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
	ParameterPojoClass refToPojoClass;
	String responseOne;
	public static BigDecimal currencyGBP;
	BigDecimal currencyDogeCoin;
	String responseTwo;

	@Given("^All query parameters assigned to parameterPojoClass$")
	public void SetQueryParams() {
		RestAssured.baseURI = "https://pro-api.coinmarketcap.com";

		refToPojoClass = new ParameterPojoClass();
		refToPojoClass.setAmount(10000000);
		refToPojoClass.setIdOne("3541");
		refToPojoClass.setConvertOne("GBP");
		refToPojoClass.setSourceURI("/v2/tools/price-conversion");
		refToPojoClass.setIdTwo("2791");
		refToPojoClass.setConvertTwo("DOGE");
	}

	@When("^User makes call to price-conversion api$")
	public void MakeApiCallGBP() {
		responseOne = given().queryParam("amount", refToPojoClass.getAmount()).queryParam("id", refToPojoClass.getIdOne())
				.queryParam("convert", refToPojoClass.getConvertOne()).header("X-CMC_PRO_API_KEY", refToPojoClass.getApiKey())
				.header("Content-Type", "application/json").when().get(refToPojoClass.getSourceURI()).then().extract().response().asString();
	}

	@Then("^Input currency is changed to GBP currency$")
	public void GetConvertedCurrencyGBP() {
		refToFunction = Utilities::JsonParserGBP;
		currencyGBP = refToFunction.apply(responseOne);
		System.out.println("Base currency was: Guatemalan Quetzal with amount: " + refToPojoClass.getAmount());
		System.out.println("Converted GBP are: " + currencyGBP);
	}

	@When("^User pass converted GBP to API$")
	public void MakeApiCallD() {
		responseTwo = given().queryParam("amount", currencyGBP).queryParam("id", refToPojoClass.getIdTwo())
				.queryParam("convert", refToPojoClass.getConvertTwo()).header("X-CMC_PRO_API_KEY", refToPojoClass.getApiKey())
				.header("Content-Type", "application/json").when().get(refToPojoClass.getSourceURI()).then().extract().response().asString();
	}

	@Then("GBP currency is changed to Dogecoin")
	public void GetConvertedCurrencyD() {
		refToFunction = Utilities::JsonParserD;
		currencyDogeCoin = refToFunction.apply(responseTwo);
		System.out.println("Base currency was: GGBP with amount: " + currencyGBP);
		System.out.println("Converted Dogecoin are: " + currencyDogeCoin);
	}
	

}
