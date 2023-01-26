package Utilities;

public class ParameterPojoClass 
{
	private String sourceURI;
	private long amount;
	private String idOne;
	private String idTwo;
	private String convertOne;
	private String convertTwo;
	private String apiKey="e60b6405-769c-411a-8a10-ee5cb19ff52a";
	public String getSourceURI() {
		return sourceURI;
	}
	public void setSourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getIdOne() {
		return idOne;
	}
	public void setIdOne(String idOne) {
		this.idOne = idOne;
	}
	public String getIdTwo() {
		return idTwo;
	}
	public void setIdTwo(String idTwo) {
		this.idTwo = idTwo;
	}
	public String getConvertOne() {
		return convertOne;
	}
	public void setConvertOne(String convertOne) {
		this.convertOne = convertOne;
	}
	public String getConvertTwo() {
		return convertTwo;
	}
	public void setConvertTwo(String convertTwo) {
		this.convertTwo = convertTwo;
	}
	public String getApiKey() {
		return apiKey;
	}
}
