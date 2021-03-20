package json;

import json.handlers.JsonBodyHandler;
import models.Result;
import models.Event;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class ApiPredictHQ {

    private final static String accessToken = "Wal1qLLD4kBMT_TYsryu653IHrC8x7fKyxzQjkFe";

    public static ArrayList<Result> basicSearch()

    {

        try {
            String host = "https://api.predicthq.com/v1/events/";
            List<String> parameters = new ArrayList<>();
            parameters.add("category=disasters%2Cterror%2Chealth-warnings");
            parameters.add("limit=20");
            //parameters.add("country=JP");
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
