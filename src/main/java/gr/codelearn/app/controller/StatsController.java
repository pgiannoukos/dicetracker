package gr.codelearn.app.controller;

import gr.codelearn.app.service.VisitService;
// import gr.codelearn.app.service.AnimalDiceService;
// import gr.codelearn.app.service.ShapeDiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * This class deals with the creation of endpoints that a user of our application can access. Endpoints are basically
 * the URLs a user can access through a browser. Each "endpoint" method is represented by three things:
 *
 * 1) A mapping which can be accessed through the GET HTTP Verb (@GetMapping) (usually  used for requesting a
 * html file or refreshing a page) or through the POST HTTP Verb (@PostMapping) (usually used for submitting forms).
 *
 * 2) A String return type. Each String return type represents an html/ftl file that is located under the directory:
 * resources/freemarker. The "return String" should have the same exact name as the files located under that directory.
 * There are cases where we can perform a redirection to another endpoint, as it can be seen in the throwDice() method.
 *
 * 3) Model & Redirect attributes. In both of these, you add attributes and values that are parsed to the return html/ftl
 * files. A Model attribute basically means that each time an endpoint is accessed, the returned file will ALWAYS
 * have an added value, even if it is null. A Redirect attribute is an attribute that is only returned during the
 * redirection towards another endpoint. This attribute will only be added during the redirection to that endpoint. Let's
 * say we have endpoint A, which returns a html/ftl file with a model attribute added to it, and endpoint B which redirects
 * to endpoint A and adds a redirect attribute. If the user accesses endpoint B, then the redirect attribute is added,
 * and then redirection to endpoint A happens. Endpoint A executes the code that is contained within the method (in this
 * case it adds a model attribute) and returns the html/ftl file. The final html/ftl file will not only contain the
 * model attribute that was added, but also the redirect attribute, as the original request begun from endpoint B.
 * If the user now decides to refresh the page, then endpoint A is accessed, and the only attribute that exists is the
 * model one. The redirect attribute disappears
 */
@Controller
public class StatsController {

    private VisitService visitService;
    // private AnimalDiceService animalDiceService;
    // private ShapeDiceService shapeDiceService;

    public StatsController() {
        this.visitService = new VisitService();
    }

    @GetMapping("/viewStatistics")
    public String viewStatistics(Model model) {
        model.addAttribute("allVisitResults", visitService.getAllVisitResults());
        return "viewStatistics";
    }

    @PostMapping("/resetStatistics")
    public String resetStatistics(Model model) {
        visitService.resetStatistics();
        return "resetStatistics";
    }
}

