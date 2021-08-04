package co.com.rappi.certification.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class GetUser implements Task {
    private String url;

    public GetUser(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(url).with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }

    public static GetUser response(String url) {
        return Tasks.instrumented(GetUser.class, url);
    }
}
