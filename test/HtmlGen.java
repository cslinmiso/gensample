import static play.test.Helpers.contentAsString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

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
    Content html = views.html.index.render();
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
