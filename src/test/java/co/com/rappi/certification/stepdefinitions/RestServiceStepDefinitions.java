package co.com.rappi.certification.stepdefinitions;

import co.com.rappi.certification.exceptions.ExceptionError;
import co.com.rappi.certification.interactions.Obtain;
import co.com.rappi.certification.questions.GetResources;
import co.com.rappi.certification.questions.ResponseCode;
import co.com.rappi.certification.tasks.GetResource;
import co.com.rappi.certification.tasks.GetUser;
import co.com.rappi.certification.tasks.PostCreate;
import co.com.rappi.certification.utils.MsgError;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


import java.util.Map;

import static co.com.rappi.certification.utils.Constant.userCreate;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class RestServiceStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("(.*) create a user with the get method in (.*)")
    public void createAUserWithThePostMethod(String nameActor, String baseUrl) {
        theActorCalled(nameActor).whoCan(CallAnApi.at(baseUrl));
    }

    @When("User get response (.*)")
    public void userGetResponse(String url) {
        theActorInTheSpotlight().attemptsTo(GetUser.response(url));
    }

    @When("User post response (.*)")
    public void userPostResponse(String url, Map<String, String> dataList) {
        theActorInTheSpotlight().attemptsTo(PostCreate.user(url, PostCreate.bodyCreate(dataList)));
    }

    @When("Obtain information registered")
    public void obtainInformationRegistered() {
        theActorInTheSpotlight().attemptsTo(Obtain.response());
    }

    @When("User get resource list (.*)")
    public void userGetResourceList(String url) {
        theActorInTheSpotlight().attemptsTo(GetResource.list(url));
    }

    @Then("^User verifies the response obtained (.*)$")
    public void userVerifiesTheResponseObtained(String response) {
        theActorInTheSpotlight().should(seeThat(ResponseCode.succesfully(), containsString(response)).orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));

    }

    @Then("^The user verifies the response obtained with their (.*)$")
    public void theUserVerifiesTheResponseObtainedWithTheirName(String name) {
        theActorInTheSpotlight().should(seeThat(GetResources.succesfully(), containsString(name)).orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));
    }

    @Then("^The user verifies the response is null$")
    public void theUserVerifiesTheResponseIsNull() {
        theActorInTheSpotlight()
                .should(seeThatResponse(response -> response.body(
                        "data.name", equalTo(null),
                        "data.job", equalTo(null)))
                        .orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));
    }
}

