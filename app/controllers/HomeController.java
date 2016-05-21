package controllers;

import java.util.List;
import java.util.Map;

import org.apache.http.HttpRequest;
import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.User;
import play.Logger;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.RequestBody;
import views.html.*;
import play.api.libs.json.*;
public class HomeController extends Controller {

	public Result index() {
		return ok(index.render("ABC"));
	}

	public Result view1() {
		return ok(view1.render(""));
	}

	public Result addUser() {
		// 获取表单提交数据
		Map<String, String[]> params = request().body().asFormUrlEncoded();
		if (params != null) {
			// 打印接收到的表单数据
			System.out.println(params);

			// 解释收到的form数据
			String un = params.get("username")[0];
			String fn = params.get("firstname")[0];
			String ln = params.get("lastname")[0];
			String addr = params.get("address")[0];
			// 创建一个User对象
			User user = new User(un, fn, ln, addr);

			// 保存到数据库
			try {
				user.save();
				return ok("ok");
			} catch (Exception e) {
				return ok(e.getMessage());
			}

		} else {
			return badRequest("Expecting form data(form is null)");
		}

	}

	public Result getUser() {
		// 创建一个对象
		List<User> all = User.find.all();
		// 解析拿到的数据
		for (int i = 0; i < all.size(); i++) {
			User user = all.get(i);
			String username = user.getUsername();
			String firstname = user.getFirstname();
			String lastname = user.getLastname();
			String address = user.getAddress();
			System.out.println("user:" + user.toString());
			System.out.println("json" + user.toJson());
		}
		ObjectNode json = Json.newObject();

		return ok(view2.render(""));

	}

}
