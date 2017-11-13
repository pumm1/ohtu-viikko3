package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.*;
import org.apache.http.client.fluent.Request;

public class Main {
//en saanut tehtäviä toimimaan

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        //"011120775"
        String studentNr = "011120775";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        url = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String bText = Request.Get(url).execute().returnContent().asString();
        
        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);
        System.out.println("------");
        System.out.println(bText);
        Gson mapper = new Gson();
        
        Maksimi max = mapper.fromJson(bText, Maksimi.class);
        List<Integer> t = max.getExer();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
//        subs = mapper.fromJson(bText, Submission[].class);
        System.out.println("Oliot:");
        for (Submission submission : subs) {
            submission.setMax(t);
            System.out.println(submission);
        }

    }
}
