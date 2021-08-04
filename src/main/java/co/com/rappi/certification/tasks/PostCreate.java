package co.com.rappi.certification.tasks;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static co.com.rappi.certification.utils.Constant.userCreate;

public class PostCreate implements Task {
    private String url;
    private String body;

    public PostCreate(String url, String body) {
        this.url = url;
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(url).with(request -> request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON).body(body)));
        ResponseBody responseBody = SerenityRest.lastResponse().getBody();
        String body = responseBody.asString();
        JSONObject jsonObject = new JSONObject(body);
        actor.remember("id", jsonObject.getString("id"));
        actor.remember("endpoint", url);
    }

    public static String bodyCreate(Map<String, String> dataList) {
        userCreate.setName(dataList.get("name"));
        userCreate.setJob(dataList.get("job"));
        Map<String, String> user = new HashMap<>();
        Gson gson = new Gson();
        user.put("name", dataList.get("name"));
        user.put("job", dataList.get("job"));
        return gson.toJson(user);
    }

    public static PostCreate user(String url, String body) {
        return Tasks.instrumented(PostCreate.class, url, body);
    }
}
