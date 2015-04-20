package controllers;

import play.api.templates.Html;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

  public static Result index() {
    Html html = views.html.index.render();
    return ok(html);
  }

}
