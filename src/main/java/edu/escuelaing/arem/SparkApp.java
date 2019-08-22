package edu.escuelaing.arem;

import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h1>Here you'd can calculate mean and standard deviation upon a group of numbers</h2>"
                + "<form action=\"/results\">"
                + "  Please instert your numbers with a space between them:<br>"
                + "  <input type=\"text\" name=\"Numbers\" value=\"\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Calculate\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        String values = req.queryParams("Numbers");
        List<String> lS = new ArrayList<String>(Arrays.asList(values.split(",")));
        LinkedList lK = new LinkedList();
        for (int i = 0; i < lS.size(); i++) {
            lK.append(Double.parseDouble(lS.get(i)));
        }
        return "The median of your group numbers is: " + App.mean(lK) + "and the standard deviation is: " + App.standardDev(lK);
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
