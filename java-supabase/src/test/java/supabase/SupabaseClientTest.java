package supabase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.gilvan.SupabaseClient;
import dev.gilvan.SupabaseConnector;

public class SupabaseClientTest {
    String schema = "public";
    String tableName = "table_test";

    SupabaseClient client = new SupabaseClient(new SupabaseConnector());

    @Test
    void getPaginate() {
        SupabaseClient client = new SupabaseClient(new SupabaseConnector());
        var response = client.table(schema, tableName).getPaginate(0, 4);
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void getByName() {
        SupabaseClient client = new SupabaseClient(new SupabaseConnector());
        var response = client.table(schema, tableName).getBy("name", "user_2");
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void insert() {
        String body = "{ \"name\": \"usertest_5\", \"age\": 37, \"birthday\": \"2010-03-03\"}";
        SupabaseClient client = new SupabaseClient(new SupabaseConnector());
        var response = client.table(schema, tableName).insert(body);
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    void edit() {
        String body = "{ \"name\": \"usertest_5\", \"age\": 25}";
        SupabaseClient client = new SupabaseClient(new SupabaseConnector());
        var response = client.table(schema, tableName).edit("name", "usertest_5", body);
        Assertions.assertEquals(204, response.statusCode());
    }

    @Test
    void delete() {
        SupabaseClient client = new SupabaseClient(new SupabaseConnector());
        var response = client.table(schema, tableName).delete("name", "usertest_5");
        Assertions.assertEquals(204, response.statusCode());
    }
}
