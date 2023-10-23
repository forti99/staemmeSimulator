package datenverarbeitung;

import util.Rohstoffe;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DataProcessor {
    private static final Map<Integer, Gebaeude> gebaeudeDaten = new HashMap<>();


    public static void loadGebaeudeInfos(String welt) throws Exception {
        String url = "https://de" + welt + ".die-staemme.de/interface.php?func=get_building_info";
        parseXmlToGebaeude(url);
    }

    public static void parseXmlToGebaeude(String xmlUrl) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(xmlUrl).openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder xmlResponse = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            xmlResponse.append(line);
        }
        reader.close();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlResponse.toString())));

        fillGebaeudeDaten(new Gebaeude(1), doc.getElementsByTagName("main").item(0));
        fillGebaeudeDaten(new Gebaeude(2), doc.getElementsByTagName("barracks").item(0));
        fillGebaeudeDaten(new Gebaeude(3), doc.getElementsByTagName("stable").item(0));
        fillGebaeudeDaten(new Gebaeude(4), doc.getElementsByTagName("garage").item(0));
        fillGebaeudeDaten(new Gebaeude(5), doc.getElementsByTagName("church").item(0));
        fillGebaeudeDaten(new Gebaeude(6), doc.getElementsByTagName("church_f").item(0));
        fillGebaeudeDaten(new Gebaeude(7), doc.getElementsByTagName("watchtower").item(0));
        fillGebaeudeDaten(new Gebaeude(8), doc.getElementsByTagName("snob").item(0));
        fillGebaeudeDaten(new Gebaeude(9), doc.getElementsByTagName("smith").item(0));
        fillGebaeudeDaten(new Gebaeude(10), doc.getElementsByTagName("place").item(0));
        fillGebaeudeDaten(new Gebaeude(11), doc.getElementsByTagName("statue").item(0));
        fillGebaeudeDaten(new Gebaeude(12), doc.getElementsByTagName("market").item(0));
        fillGebaeudeDaten(new Gebaeude(16), doc.getElementsByTagName("farm").item(0));
        fillGebaeudeDaten(new Gebaeude(17), doc.getElementsByTagName("storage").item(0));
        fillGebaeudeDaten(new Gebaeude(18), doc.getElementsByTagName("hide").item(0));
        fillGebaeudeDaten(new Gebaeude(19), doc.getElementsByTagName("wall").item(0));
        fillRohstoffGebaeudeDaten(doc.getDocumentElement().getChildNodes());
    }

    private static void fillGebaeudeDaten(Gebaeude gebaeude, Node gebaeudeNode) {
        if (gebaeudeNode != null) {
            fillGebaeudegrunddaten(gebaeude, gebaeudeNode);
            fillGebaeudekosten(gebaeude);
        }

        gebaeudeDaten.put(gebaeude.getId(), gebaeude);
    }

    private static void fillGebaeudegrunddaten(Gebaeude gebaeude, Node gebaeudeNode) {
        gebaeude.setMaxLevel(Integer.parseInt(getNodeTextContent(gebaeudeNode, "max_level")));
        gebaeude.setMinLevel(Integer.parseInt(getNodeTextContent(gebaeudeNode, "min_level")));
        gebaeude.setWood(Integer.parseInt(getNodeTextContent(gebaeudeNode, "wood")));
        gebaeude.setStone(Integer.parseInt(getNodeTextContent(gebaeudeNode, "stone")));
        gebaeude.setIron(Integer.parseInt(getNodeTextContent(gebaeudeNode, "iron")));
        gebaeude.setPop(Integer.parseInt(getNodeTextContent(gebaeudeNode, "pop")));
        gebaeude.setWoodFactor(Double.parseDouble(getNodeTextContent(gebaeudeNode, "wood_factor")));
        gebaeude.setStoneFactor(Double.parseDouble(getNodeTextContent(gebaeudeNode, "stone_factor")));
        gebaeude.setIronFactor(Double.parseDouble(getNodeTextContent(gebaeudeNode, "iron_factor")));
        gebaeude.setPopFactor(Double.parseDouble(getNodeTextContent(gebaeudeNode, "pop_factor")));
        gebaeude.setBuildTime(Double.parseDouble(getNodeTextContent(gebaeudeNode, "build_time")));
    }

    private static void fillGebaeudekosten(Gebaeude gebaeude) {
        Map<Integer, Rohstoffe> baukostenProStufe = new HashMap<>();
        Map<Integer, Integer> bevoelkerungskostenProStufe = new HashMap<>();

        int maxLevel = gebaeude.getMaxLevel();
        int wood = gebaeude.getWood();
        int stone = gebaeude.getStone();
        int iron = gebaeude.getIron();
        int pop = gebaeude.getPop();
        double woodFactor = gebaeude.getWoodFactor();
        double stoneFactor = gebaeude.getStoneFactor();
        double ironFactor = gebaeude.getIronFactor();
        double popFactor = gebaeude.getPopFactor();

        int popCostLevelBefore = 0;
        for (int i = 0; i < maxLevel; i++) {

            int woodCost = (int) Math.round(round(wood * Math.pow(woodFactor, i), 8));
            int stoneCost = (int) Math.round(round((stone * Math.pow(stoneFactor, i)), 8));
            int ironCost = (int) Math.round(round((iron * Math.pow(ironFactor, i)), 8));
            baukostenProStufe.put(i + 1, new Rohstoffe(woodCost, stoneCost, ironCost));


            int popCost = (int) Math.round(round((pop * Math.pow(popFactor, i)),8));
            bevoelkerungskostenProStufe.put(i + 1, popCost-popCostLevelBefore);
            popCostLevelBefore = popCost;
        }

        gebaeude.setBaukostenProStufe(baukostenProStufe);
        gebaeude.setBevoelkerungskostenProStufe(bevoelkerungskostenProStufe);
    }

    private static String getNodeTextContent(Node parent, String tagName) {
        Node node = ((Element) parent).getElementsByTagName(tagName).item(0);
        return node.getTextContent();
    }

    private static void fillRohstoffGebaeudeDaten(NodeList topLevelElements) {
        for (int i = 0; i < topLevelElements.getLength(); i++) {
            Node node = topLevelElements.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("wood")) {
                fillGebaeudeDaten(new Gebaeude(13), node);
            }
            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("stone")) {
                fillGebaeudeDaten(new Gebaeude(14), node);
            }
            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("iron")) {
                fillGebaeudeDaten(new Gebaeude(15), node);
            }
        }

    }

    /*
    Methode zum Runden vor dem eigentlichen Runden auf eine Ganzzahl um zu verhindern, dass wegen der Double-Ungenauigkeit
    z.B. 229,499999997 zu 229 gerundet wird. Eigentlich ist 229,499999997 = 229,5 und muss damit zu 230 gerundet werden
     */
    private static double round(double value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }

    public static Map<Integer, Gebaeude> getGebaeudeDaten() {
        return gebaeudeDaten;
    }
}
