package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import models.User;
import play.db.ebean.EbeanConfig;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class UserController extends Controller {

    private final EbeanServer ebeanServer;

    @Inject
    public UserController(EbeanConfig ebeanConfig) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result list() {
//        List<User> userList = ebeanServer.find(User.class).findList();
        List<User> userList = User.find.all();
        System.out.println(userList);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode objectNode = mapper.createObjectNode().put("total", userList.size()).set("data", Json.toJson(userList));
        return ok(objectNode);
    }

    public Result save() {
        System.out.println("save");
        JsonNode json = request().body().asJson();
        if(json == null) {
            System.out.println(request().body().asJson());
            return badRequest("Expecting Json data");
        } else {
            System.out.println("save in progress");
            String fullName = json.findPath("fullName").textValue();
            String email = json.findPath("email").textValue();
            String password = json.findPath("password").textValue();
            // Data createTime = new Date();
            User user = new User();
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPassword(password);
            user.setCreateTime(new Date());
            System.out.println(user);
            user.save();
        }
        return ok("Sign up Successfully");
    }
    public Result detail(long userId) {
        User user = User.find.byId(userId);
        if (user == null) {
            return notFound();
        } else {
            return ok(Json.toJson(user));
        }
    }

    public Result update(long userId) {
        List<User> userList = ebeanServer.find(User.class).findList();
        System.out.println(userList);
        return ok(Json.toJson(userList));
    }

    public Result delete(long userId) {
        User user = User.find.byId(userId);
        if (user == null) {
            return notFound();
        } else {
            User.find.deleteById(userId);
            return ok();
        }
    }


}
