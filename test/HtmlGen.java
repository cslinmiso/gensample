import static play.test.Helpers.contentAsString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import org.junit.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
import play.mvc.Content;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are
 * interested in mocking a whole application, see the wiki for more details.
 * 
 */
public class HtmlGen {

  @Test
  public void renderTemplate() {
    
    ObjectNode root = Json.newObject();
    root.put("title", "This is title");
    
    ObjectNode n1 = Json.newObject();
    n1.put("N1.name", "This is N1 Name");
    
    ArrayNode an = Json.newObject().arrayNode();    
    an.add(1);
    an.add(2);
    an.add(3);
    
    n1.put("N1.arraySample", an);
    
    HashMap<String, ObjectNode> dataMap = new HashMap<>();
    dataMap.put("root", root);
    dataMap.put("N1", n1);

    Content html = views.html.index.render(dataMap);
    String out = contentAsString(html);

    String targetDir = "/tmp/output/www.eztravel.com.tw/";

    PrintWriter f = null;
    File dir = null;
    try {
      dir = new File(targetDir);
      dir.deleteOnExit();
      boolean result = dir.mkdirs();
      f = new PrintWriter(targetDir + "index.html");
      f.write(out);
      System.out.println(out);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      f.close();
    }

  }

}
