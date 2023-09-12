package fr.hadeen.getresponse.config;
public class GetResponseProperties implements GetResponseConfigurationInterface {
    private String baseUrl = "https://api.getresponse.com/v3";
    private String apiKey;

    @Override
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public static GetResponseProperties forKey(String key) {
        final GetResponseProperties properties = new GetResponseProperties();
        properties.setApiKey("api-key " + key);
        return properties;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
