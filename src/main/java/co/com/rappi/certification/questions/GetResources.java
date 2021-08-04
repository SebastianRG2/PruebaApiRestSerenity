package co.com.rappi.certification.questions;

import co.com.rappi.certification.models.Data;
import co.com.rappi.certification.models.Resource;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.rappi.certification.utils.Constant.data;

public class GetResources implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        Data resource = SerenityRest.lastResponse().as(Resource.class).getData().stream().filter(x -> x.getId() == 1).findFirst().orElse(null);
        data.setName(resource.getName());
        return data.getName();
    }

    public static Question<String> succesfully() {
        return new GetResources();
    }

}
