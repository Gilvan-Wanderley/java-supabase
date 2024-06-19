package dev.gilvan;

import java.io.InputStream;
import java.util.Properties;

public class SupabaseConnector {
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    private void setApiKey(String apiKey) {
        if (apiKey == null)
            throw new IllegalArgumentException("API_KEY not setting.");
        this.apiKey = apiKey;
    }

    private String baseURL;

    public String getBaseURL() {
        return baseURL;
    }

    private void setBaseURL(String baseURL) {
        if (baseURL == null)
            throw new IllegalArgumentException("BASE_URL not setting.");
        this.baseURL = baseURL;
    }

    public SupabaseConnector() {
        try (InputStream input = SupabaseConnector.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null)
                throw new ExceptionInInitializerError("Sorry, could not find config.properties.");
            Properties properties = new Properties();
            properties.load(input);

            setApiKey(properties.getProperty("API_KEY"));
            setBaseURL(properties.getProperty("BASE_URL"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SupabaseConnector(String apiKey, String baseURL) {
        setApiKey(apiKey);
        setBaseURL(baseURL);
    }

}
