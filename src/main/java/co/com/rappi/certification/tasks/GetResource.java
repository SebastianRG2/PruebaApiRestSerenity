package co.com.rappi.certification.tasks;


import io.restassured.http.ContentType;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;


import org.apache.http.HttpHeaders;


public class GetResource implements Task {
    private String url;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(url.replace(" ", "")).with(requestSpecification -> requestSpecification.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON))
        );
    }

    public GetResource(String url) {
        this.url = url;
    }

    public static GetResource list(String url) {
        return Tasks.instrumented(GetResource.class, url);
    }
}
