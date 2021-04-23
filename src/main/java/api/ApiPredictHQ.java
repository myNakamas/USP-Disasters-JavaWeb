package api;

import api.handlers.JsonBodyHandler;
import models.Result;
import models.Event;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class ApiPredictHQ {
//todo: oopsieee the access token wore off.. We need a new one or to find a new api/
    private final static String accessToken = "Wal1qLLD4kBMT_TYsryu653IHrC8x7fKyxzQjkFe";
    private static String host = "https://api.predicthq.com/v1/events/";
    private static List<String> parameters= new ArrayList<>();

    public static ArrayList<Result> basicSearch() throws IOException, InterruptedException {
            parameters = new ArrayList<>();
            parameters.add("category=disasters%2Cterror%2Chealth-warnings");
            parameters.add("limit=10");
            return search(parameters);
    }


    public static ArrayList<Result> FilteredSearch(String countryCode) throws IOException, InterruptedException {
        parameters = new ArrayList<>();
        parameters.add("category=disasters%2Cterror%2Chealth-warnings");
        parameters.add("limit=10");
        parameters.add("country="+countryCode);

        return search(parameters);
    }

    private static ArrayList<Result> search(List<String> parameters) throws IOException, InterruptedException {
        host += "?";
        StringBuilder hostBuilder = new StringBuilder(host);
        for (String x : parameters) {
            hostBuilder.append(x).append("&");
        }
        host = hostBuilder.toString();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(host))
                .headers(
                        "Authorization", " Bearer " + accessToken,
                        "Accept", "application/json"
                )
                .build();
        HttpResponse<Supplier<Event>> response =client.send(request, new JsonBodyHandler<>(Event.class));
        return response.body().get().getResults();
    }


}
