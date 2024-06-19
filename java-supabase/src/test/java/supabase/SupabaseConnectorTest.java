package supabase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.gilvan.SupabaseConnector;

public class SupabaseConnectorTest {

    @Test
    public void DefaultCreateSupabaseConnector() {
        SupabaseConnector connector = new SupabaseConnector();
        Assertions.assertNotNull(connector);
        Assertions.assertNotNull(connector.getApiKey());
        Assertions.assertNotNull(connector.getBaseURL());
    }

    @Test
    public void SettingCreateSupabaseConnector() {
        String apiKey = "api_key";
        String baseURL = "base_url";
        SupabaseConnector connector = new SupabaseConnector(apiKey, baseURL);
        Assertions.assertNotNull(connector);
        Assertions.assertEquals(apiKey, connector.getApiKey());
        Assertions.assertEquals(baseURL, connector.getBaseURL());
    }

    @Test
    public void notSettingApiKey() {
        String baseURL = "base_url";
        Assertions.assertThrowsExactly(IllegalArgumentException.class, 
                                       () -> new SupabaseConnector(null, baseURL));
        
    }

    @Test
    public void notSettingBaseURL() {
        String apiKey = "api_key";
        Assertions.assertThrowsExactly(IllegalArgumentException.class, 
                                       () -> new SupabaseConnector(apiKey, null));
        
    }
}
