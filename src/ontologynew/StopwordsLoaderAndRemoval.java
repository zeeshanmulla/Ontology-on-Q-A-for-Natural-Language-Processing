package ontologynew;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class StopwordsLoaderAndRemoval {

    public static List<String> lines = new ArrayList<String>();
    public static boolean flag = false;
//    public  static int sw_found = 0;

    public static int count = 0;

    public static void StopWordLoader() {

        if (!flag) {
            File dir = new File("stopword");
            try {
                String UplodedFilecontent = FileUtils.readFileToString(dir);
                lines = Arrays.asList(UplodedFilecontent.split("\\r?\\n"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Number of Stopwordloaded:" + lines.size());
            flag = true;
        }

    }

    public static String StopwordsRemoval(String content) {
        count = 0;
        Steamming s = new Steamming();
        String words[] = content.split("\\s+");
        String filtrateContent = "";
        for (String w : words) {
            if (!lines.contains(w)) {
//                filtrateContent = filtrateContent + " " + s.Steamming(w);
                filtrateContent = filtrateContent + " " + w;
            } else {
                count++;
            }
        }

        System.out.println("Number of Stopword Detected:" + count);
        return filtrateContent;
    }
}
