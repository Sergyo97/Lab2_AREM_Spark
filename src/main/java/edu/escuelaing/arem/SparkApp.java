package edu.escuelaing.arem;

import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

import javax.management.Query;

/**
 * Minimal web app example for Heroku using SparkWeb
 *
 * @author Sergio Ruiz
 */
public class SparkApp {

    /**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple Hello World web app. It maps the lambda function to the
     * /hello relative URL.
     */
    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));

        post("/mean", (req, res) -> {
            QueryParamsMap qmp = req.queryMap();
            String[] values = qmp.get("values").value().split(" ");
            LinkedList lK = new LinkedList();
            for(String val : values){
                lK.append(Double.parseDouble(val));
            }
            return App.mean(lK);
        });

        post("/devStandard", (req, res) -> {
            QueryParamsMap qmp = req.queryMap();
            String[] values = qmp.get("values").value().split(" ");
            LinkedList lK = new LinkedList();
            for(String val : values){
                lK.append(Double.parseDouble(val));
            }
            return App.standardDev(lK);
        });
    }

    private static String resultsPage(Request req, Response res) {
        return req.queryParams("firstname") + " " +
                req.queryParams("lastname");
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h1>Here you'd can calculate mean and standard deviation upon a group of numbers</h2>"
                + "<form action=\"/results\">"
                + "  Please instert your numbers with a space between them:<br>"
                + "  <input type=\"text\" name=\"firstname\" value=\"Mickey\">"
                + "  <br>"
                + "  Last name:<br>"
                + "  <input type=\"text\" name=\"lastname\" value=\"Mouse\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }


    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
