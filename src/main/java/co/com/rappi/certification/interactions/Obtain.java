package co.com.rappi.certification.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpHeaders;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Obtain implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String endpoint = theActorInTheSpotlight().recall("endpoint");
        String id = theActorInTheSpotlight().recall("id");
        theActorInTheSpotlight().attemptsTo(Get.resource(endpoint + "/" + id).with(request -> request.headers(HttpHeaders
                .CONTENT_TYPE, ContentType.JSON).log().all()));
    }

    public static Obtain response() {
        return Tasks.instrumented(Obtain.class);
    }
}
