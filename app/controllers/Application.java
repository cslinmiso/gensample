package controllers;

import java.util.HashMap;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.api.templates.Html;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

  public static Result index() {
    ObjectNode root = Json.newObject();
    root.put("title", "This is title");
    
    ObjectNode n1 = Json.newObject();
    n1.put("N1.Name", "This is N1 Name");    
    
    ArrayNode an = Json.newObject().arrayNode();    
    an.add(1);
    an.add(2);
    an.add(3);
    
    n1.put("N1.arraySample", an);
    
    HashMap<String, ObjectNode> dataMap = new HashMap<>();

    dataMap.put("root", root);
    dataMap.put("N1", n1);
    
    
    Html html = views.html.index.render(dataMap);
    return ok(html);
  }

}
