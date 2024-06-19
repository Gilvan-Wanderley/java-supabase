package dev.gilvan;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SupabaseClient {
    private final SupabaseConnector connector;
    private final HttpClient client;

    public SupabaseClient(SupabaseConnector connector) {
        this.connector = connector;
        client = HttpClient.newHttpClient();
    }

    public SupabaseTable table(String schema, String tableName) {
        return new SupabaseTable(schema, tableName);
    }

    public class SupabaseTable {
        private String schema;
        private String tableName;

        private SupabaseTable(String schema, String tableName) {
            this.schema = schema;
            this.tableName = tableName;
        }

        public HttpResponse<String> getPaginate(Integer start, Integer end) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(connector.getBaseURL() + "/rest/v1/" + tableName + "?select=*"))
                    .GET()
                    .header("apikey", connector.getApiKey())
                    .header("Accept-Profile", schema)
                    .header("Range", start + "-" + end)
                    .build();
            try {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public HttpResponse<String> getBy(String columnName, String value) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(connector.getBaseURL() + "/rest/v1/" + tableName + "?" + columnName + "=eq." + value
                            + "&select=*"))
                    .GET()
                    .header("apikey", connector.getApiKey())
                    .header("Accept-Profile", schema)
                    .build();
            try {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public HttpResponse<String> insert(String body) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(connector.getBaseURL() + "/rest/v1/" + tableName))
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .header("apikey", connector.getApiKey())
                    .header("Content-Type", "application/json")
                    .header("Prefer", "return=minimal")
                    .build();
            try {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public HttpResponse<String> edit(String columnName, String value, String body) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            connector.getBaseURL() + "/rest/v1/" + tableName + "?" + columnName + "=eq." + value))
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(body))
                    .header("apikey", connector.getApiKey())
                    .header("Content-Type", "application/json")
                    .header("Prefer", "return=minimal")
                    .build();

            try {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public HttpResponse<String> delete(String columnName, String value) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            connector.getBaseURL() + "/rest/v1/" + tableName + "?" + columnName + "=eq." + value))
                    .DELETE()
                    .header("apikey", connector.getApiKey())
                    .header("Content-Type", "application/json")
                    .header("Prefer", "return=minimal")
                    .build();
            try {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }
}
