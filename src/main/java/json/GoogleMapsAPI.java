package json;

public final class GoogleMapsAPI {
    final static String url="";

    public static String  getResult(String x,String y){
        return url+x+","+y+"&key=";
    }

}
