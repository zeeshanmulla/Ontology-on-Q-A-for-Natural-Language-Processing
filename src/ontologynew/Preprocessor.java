package ontologynew;

import static GraphCreation.GraphCreation.GraphCreation;
import static GraphCreation.GraphCreation.ReadDictionary;
import static GraphCreation.GraphCreation.getRoot;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Preprocessor {

    public static void main(String args[]) throws Exception {
        String data = "Who is mother and father of shivaji maharaj?";
        data = data.replaceAll("[&\\/\\\\#,+()$~%.'\":*?<>{}^@!।'’”“]", "").toLowerCase();
        System.out.println("After Removing Special characters:" + data);
        StopwordsLoaderAndRemoval sw = new StopwordsLoaderAndRemoval();
        sw.StopWordLoader();
        data = sw.StopwordsRemoval(data);

        ArrayList<String> AllNode = new ArrayList<String>();
        String split[] = data.split("\\s");
        for (String split1 : split) {
            if (split1.trim().length() > 0) {
                AllNode.add(split1.trim());
            }
        }
        System.out.println("AllNode:" + AllNode);
        ReadDictionary();
        String Root = getRoot(AllNode);
        System.out.println("Root: " + Root);
        GraphCreation(AllNode, Root);
    }

}
