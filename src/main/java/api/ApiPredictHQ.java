package api;

import api.handlers.JsonBodyHandler;
import com.google.protobuf.Api;
import models.Result;
import models.Event;
import models.entities.Disaster;
import services.DisasterService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class ApiPredictHQ {
//todo: oopsieee the access token wore off.. We need a new one or to find a new api
    //Client ID
    // 8AYApF_I7Kc
    //secret
    //X7WF3QPsxpMAVEukmocU7Vgss8m7n0DrNZx2N33PEFEZZ5xfoMUQVg
    //Token
    //MAISC8Jr0_EqrdC1Ug9MjMTASkTlYSu8H2wZvM1v
    private final static String accessToken = "MAISC8Jr0_EqrdC1Ug9MjMTASkTlYSu8H2wZvM1v";
    private static String host = "https://api.predicthq.com/v1/events/";
    private static List<String> parameters= new ArrayList<>();
    private static String country="";

    public static ArrayList<Result> basicSearch() throws IOException, InterruptedException {
            parameters = new ArrayList<>();
            parameters.add("category=disasters%2Cterror%2Chealth-warnings");
            parameters.add("limit=10");
        ApiPredictHQ.country="";
        return search(parameters);
    }


    public static ArrayList<Result> FilteredSearch(String countryCode) throws IOException, InterruptedException {
        parameters = new ArrayList<>();
        parameters.add("category=disasters%2Cterror%2Chealth-warnings");
        parameters.add("limit=10");
        parameters.add("country="+countryCode);
        ApiPredictHQ.country= countryCode;
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
        ArrayList<Result> results = response.body().get().getResults();
        DisasterService disasterService = new DisasterService();
        if(results==null || results.isEmpty()){
            //something went wrong!
            //get from the database
            results = new ArrayList<>();

            List<Disaster> disasters ;
            if(country.isBlank()){
                disasters =  disasterService.findAll(10);
            }
            else {
                disasters =  disasterService.findAllByCountry(country);

            }
            for(Disaster d : disasters){
                results.add(d.getAsResult());
            }
        }
        else {

            for (var result : results) {    //Save them all to the database!
                Disaster disaster = new Disaster((result));
                if (disasterService.findByDisasterId(disaster.getDisasterId()) == null)
                    disasterService.persist(disaster);
            }
        }
        return results;
    }


}
