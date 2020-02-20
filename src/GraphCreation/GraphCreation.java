/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphCreation;

import Farmes.QA_MainFrame;
import static java.awt.SystemColor.text;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Shailesh
 */
public class GraphCreation {

    public static ArrayList<String> id = new ArrayList<String>();
    public static ArrayList<String> name = new ArrayList<String>();
    public static ArrayList<String> parent = new ArrayList<String>();
    public static ArrayList<String> child = new ArrayList<String>();
    //////////////////////////////////////////////////////////////
    public static ArrayList<String> NODE = new ArrayList<String>();
    public static ArrayList<String> PARENTofNODE = new ArrayList<String>();
    public static ArrayList<String> CHILDofNODE = new ArrayList<String>();

    public static String json = "";
    public static String PanelData = "";

    public static String TreeBuilder(ArrayList<String> WordsToProcess) throws FileNotFoundException {
        json = "";
        ReadDictionary();
        String Root = FindRoot(WordsToProcess);
        GraphCreation(WordsToProcess, Root);
        return json;
    }

    public static void GraphCreation(ArrayList<String> WordsToProcess, String Root) throws FileNotFoundException {
        json = "";
        for (int i = 0; i < id.size(); i++) {
            System.out.println(id.get(i) + " " + name.get(i) + " " + parent.get(i) + " " + child.get(i));
        }
        json = "[\n"
                + "  {\n"
                + "  \"name\": \"" + Root + "\",\n"
                + "  \"parent\": \"null\"";

        PanelData = Root;
        FindChild(Root, WordsToProcess);
        json = json + " }\n"
                + "    ]";
        System.out.println(json);

        try (PrintStream out = new PrintStream(new FileOutputStream("C:\\wamp\\www\\ontology\\treeData.json"))) {
            out.print(json);
        }
    }

    public static void getGraph(String root, ArrayList<String> WordsToProcess) {
        root = root.trim();
        for (int i = 0; i < name.size(); i++) {
            if (name.get(i).contains(root)) {
                if (parent.get(i).contains(",")) {
                    String childs[] = parent.get(i).split(",");
                    for (String cld : childs) {

                        if (WordsToProcess.contains(name.get(Integer.parseInt(cld)))) {
                            json = json + ",children\": [\n"
                                    + "      {\n"
                                    + "        \"name\": \"" + name.get(Integer.parseInt(cld)) + "\",\n"
                                    + "        \"parent\": \"" + root + "\"";
                        } else {
                            getGraph(cld, WordsToProcess);
                        }
                    }
                } else if (parent.get(i).equals("NODATA")) {

                } else {
                    if (WordsToProcess.contains(name.get(Integer.parseInt(parent.get(i))))) {
                        json = json + "\",children\": [\n"
                                + "      {\n"
                                + "        \"name\": \"" + name.get(Integer.parseInt(parent.get(i))) + "\",\n"
                                + "        \"parent\": \"" + root + "\"";
                        getGraph(name.get(Integer.parseInt(parent.get(i))), WordsToProcess);
                    }

                }
            }
        }
        json = json + "}]";
    }

    public static void FindChild(String root, ArrayList<String> WordsToProcess) {
        root = root.trim();
        System.out.println("root: " + root);
        int tabcount = 1;
        for (int i = 0; i < name.size(); i++) {
            int found = 0;
            if (name.get(i).contains(root)) {
                List<String> commaSeprated = Arrays.asList(name.get(i).split(","));
                for (String single : commaSeprated) {
                    if (single.equals(root)) {
                        commaSeprated = Arrays.asList(parent.get(i).split(","));
                        for (String singleChild : commaSeprated) {
                            if (!singleChild.equals("NODATA")) {
                                if (WordsToProcess.contains(name.get(Integer.parseInt(singleChild.trim())))) {
                                    System.out.println("Child: of " + root + " is " + name.get(Integer.parseInt(singleChild.trim())));
                                    if (found != 0) {
                                        json = json + "\n" + "},";
                                    }
                                    if (found == 0) {
                                        json = json + " ,\"children\": [\n";
                                        found++;
                                    }
                                    json = json + "\n" + " {\"name\": \"" + name.get(Integer.parseInt(singleChild.trim())) + "\",\n"
                                            + "        \"parent\": \"" + root + "\"";
                                    
                                    if(found>0){
                                         PanelData = root+" is "+name.get(Integer.parseInt(singleChild.trim()));
                                    }
                                    FindChild(name.get(Integer.parseInt(singleChild.trim())), WordsToProcess);
                                }
                            }
                        }
                    }
                }
                if (found != 0) {
                    json = json + "}]";
                }
            }
        }
    }

    public static void FindParent(String word, ArrayList<String> WordsToProcess) {
        ReadDictionary();
        word = word.trim();
        for (int i = 0; i < name.size(); i++) {
            if (name.get(i).contains(word)) {
                List<String> commaSeprated = Arrays.asList(name.get(i).split(","));
                for (String single : commaSeprated) {
                    if (single.equals(word)) {
                        if (!parent.get(i).equals("NODATA")) {
                            System.out.println("Parent: of " + word + " is " + name.get(Integer.parseInt(parent.get(i).trim())));
                        }
                        if (!NODE.contains(word)) {
                            NODE.add(word);
                        }
                        PARENTofNODE.add(parent.get(i));
                    }
                }
            }
        }
    }

    public static void ReadDictionary() {
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("dictionary\\"+QA_MainFrame.jComboBox1.getSelectedItem()));
            while ((sCurrentLine = br.readLine()) != null) {
                String lines[] = sCurrentLine.split("\\s+");
                if (lines.length > 0) {
                    if (!lines[0].equals("-")) {
                        id.add(lines[0].trim());
                    } else {
                        id.add("NODATA");
                    }
                }
                if (lines.length > 1) {
                    if (!lines[1].equals("-")) {
                        name.add(lines[1].trim());
                    } else {
                        name.add("NODATA");
                    }
                } else {
                    name.add("NODATA");
                }
                if (lines.length > 2) {
                    if (!lines[2].equals("-")) {
                        parent.add(lines[2].trim());
                    } else {
                        parent.add("NODATA");
                    }
                } else {
                    parent.add("NODATA");
                }
                if (lines.length > 3) {
                    if (!lines[3].equals("-")) {
                        child.add(lines[3].trim());
                    } else {
                        child.add("NODATA");
                    }
                } else {
                    child.add("NODATA");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ArrayList<String> AddNode(ArrayList<String> WordsToProcess, String Root) {
      
        for (int i = 0; i < WordsToProcess.size(); i++) {
            if (!(FinalNode.contains(WordsToProcess.get(i)))) {
                FinalNode.add(WordsToProcess.get(i));
            }
        }

        for (int i = 0; i < WordsToProcess.size(); i++) {
            if (WordsToProcess.get(i).equals(Root)) {
                System.out.println("Find Root");
            } else {
                for (int j = 0; j < name.size(); j++) {
                    if (WordsToProcess.get(i).equals(name.get(j))) {
                        System.out.println("Find " + WordsToProcess.get(i));
                        System.out.println("parent " + parent.get(j));
                        String allparent[] = parent.get(j).split(",");
                        ArrayList<String> node = addInArray(allparent);
                        for (String node1 : node) {
                            if (!(FinalNode.contains(name.get(j)))) {
                                FinalNode.add(node1);
//                                PanelData = PanelData+node1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(FinalNode);
        return FinalNode;
    }

    public static ArrayList<String> FinalNode = new ArrayList<String>();

    public static ArrayList<String> addInArray(String allparent[]) {
        for (String Singleparent : allparent) {
            if (!Singleparent.equals("NODATA") && Singleparent.trim().length() > 0 && FinalNode.contains(name.get(Integer.parseInt(Singleparent.toString())))) {

                String parents[] = parent.get(Integer.parseInt(Singleparent.toString())).split(",");
                for (String parent1 : parents) {
                    parent1 = parent1.trim();
                    if (parent1.equals("NODATA") || !(parent1.length() > 0)) {

                    } else {
                        String node = name.get(Integer.parseInt(parent1));
                        System.out.println("pID: " + node);
                        FinalNode.add(node);
                    }
                }
            } else {

//                Singleparent = Singleparent.trim();
//                if (Singleparent.equals("NODATA") || !(Singleparent.length() > 0)) {
//
//                } else {
//                    String node = name.get(Integer.parseInt(Singleparent));
//                    System.out.println("pID: " + node);
//                    FinalNode.add(node);
//                }

            }
        }
        return FinalNode;
    }

    public static String FindRoot(ArrayList<String> WordsToProcess) {
        String root = "";
        ArrayList<String> ROOTlist = new ArrayList<String>();
        for (int x = 0; x < WordsToProcess.size(); x++) {
            System.out.println("X: " + x);
            String word = WordsToProcess.get(x);
            boolean found = false;
            while (!found) {
                for (int i = 0; i < name.size(); i++) {
                    if (name.get(i).contains(word)) {
                        List<String> commaSeprated = Arrays.asList(name.get(i).split(","));
                        for (String single : commaSeprated) {
                            if (single.equals(word)) {
                                if (!child.get(i).equals("NODATA")) {

                                    String[] parts = child.get(i).split("\\,");
                                    word = name.get(Integer.parseInt(parts[0].trim()));
                                } else {
                                    ROOTlist.add(word);
                                    found = true;
                                }

                            }
                        }
                    }
                }
            }
        }
        Set<String> unique = new HashSet<String>(ROOTlist);
        for (String key : unique) {
            root = key;
            System.out.println(key + ": " + Collections.frequency(ROOTlist, key));
            break;
        }
        System.out.println("root: " + root);
        return root;
    }

    public static String getRoot(ArrayList<String> WordsToProcess) {
        String mainRoot = "";
        ArrayList<String> root = new ArrayList<String>();
        for (String word : WordsToProcess) {
            mainRoot = root(word, WordsToProcess);

            if (mainRoot.trim().length() > 0) {
                root.add(mainRoot);
            }

        }
        System.out.println("root: " + root);

        int count = 0;
        Set<String> unique = new HashSet<String>(root);
        for (String key : unique) {

            System.out.println(key + ": " + Collections.frequency(root, key));
            if (count < Collections.frequency(root, key)) {
                mainRoot = key;
                count = Collections.frequency(root, key);
            }
        }
        return mainRoot;
    }

    public static String root(String args, ArrayList<String> WordsToProcess) {
        String root = "";
        for (int i = 0; i < name.size(); i++) {
            if (name.get(i).equals(args)) {

                if (child.get(i).contains(",")) {
                    String parents[] = child.get(i).split(",");
                    for (String prnt : parents) {
                        root = root(prnt, WordsToProcess);
                        if (!WordsToProcess.contains(root)) {
                            root = "";
                        }
                    }
                } else if (child.get(i).equals("NODATA")) {
                    return args;
                } else {
                    root = name.get(Integer.parseInt(child.get(i)));
                    root = root(root, WordsToProcess);

                    if (!WordsToProcess.contains(root)) {
                        root = "";
                    }
                }
            }
        }
        return root;

    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> WordsToProcess = new ArrayList<String>();
        WordsToProcess.add("shivaji");
        WordsToProcess.add("brother");
        WordsToProcess.add("name");
//        WordsToProcess.add("age");
        ReadDictionary();
        String Root = getRoot(WordsToProcess);
        WordsToProcess = AddNode(WordsToProcess, Root);
        GraphCreation(WordsToProcess, Root);
        System.out.println(PanelData);
    }

}
