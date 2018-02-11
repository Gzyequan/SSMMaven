package com.yequan.controller;

import com.alibaba.fastjson.JSON;
import com.yequan.constant.Const;
import com.yequan.model.User;
import com.yequan.service.IUserService;
import com.yequan.tool.JavaWebToken;
import com.yequan.tool.LongId;
import com.yequan.tool.PublicMethod;
import com.yequan.type.ResultAddOneUser;
import com.yequan.type.ResultLogin;
import com.yequan.type.ResultUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public void login(@RequestBody User user, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        ResultLogin resultLogin = new ResultLogin();
        if (null != user) {
            User loginUser = this.userService.checkEmailAndPassword(user.getEmail(), user.getPassword());
            if (null != loginUser) {
                resultLogin.setCode(Const.SUCCESS);
                resultLogin.setReason(Const.SUCCESSREASONLOGIN);
                resultLogin.setUserId(loginUser.getId());
                Map<String, Object> m = new HashMap<>();
                m.put("email", loginUser.getEmail());
                m.put("id", loginUser.getId());
                String token = JavaWebToken.createJavaWebToken(m);
                resultLogin.setToken(token);
                String jsonString = JSON.toJSONString(resultLogin);
                response.getWriter().write(jsonString);
                response.getWriter().close();
            } else {
                resultLogin.setCode(Const.FAILURE);
                resultLogin.setReason(Const.FAILUREREASONLOGIN);
                String jsonString = JSON.toJSONString(resultLogin);
                response.getWriter().write(jsonString);
                response.getWriter().close();
            }
        } else {

        }
    }

    @RequestMapping(value = "/showUser.do", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ResultUser result = new ResultUser();
        String jsonString = "";
        String token = request.getHeader("authentication");
        if (null != JavaWebToken.parserJavaWebToken(token)) {
            long userId = Long.parseLong(request.getParameter("id"));
            User user = this.userService.selectUserId(userId);
            if (null != user) {
                result.setCode(Const.SUCCESS);
                result.setReason(Const.SUCCESSREASONQUERY);
                List<User> users = new ArrayList<>();
                users.add(user);
                result.setData(users);
            } else {
                result.setCode(Const.FAILURE);
                result.setReason(Const.FAILUREREASONQUERY);
                result.setData(null);
            }
            jsonString = JSON.toJSONString(result);
            response.getWriter().write(jsonString);
            response.getWriter().close();
        } else {
            result.setCode(Const.FAILURE);
            result.setReason(Const.FAILUREREASONUNLOGIN);
            result.setData(null);
            jsonString = JSON.toJSONString(result);
            response.getWriter().write(jsonString);
            response.getWriter().close();
        }
    }

    @RequestMapping(value = "/addOneUser.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public void addOneUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        String jsonResult = "";
        ResultAddOneUser resultAddOneUser = new ResultAddOneUser();
        String token = request.getHeader("authentication");
        if (null != JavaWebToken.parserJavaWebToken(token)) {
            if (null != user) {
                if (null == this.userService.selectUserByEmail(user.getEmail())) {
                    String ipAddr = PublicMethod.getIpAddr(request);
                    long userId = LongId.getId();
                    user.setId(userId);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String currentDate = format.format(new Date());
                    user.setRegTime(currentDate);
                    user.setRegIp(ipAddr);
                    boolean b = this.userService.addOneUser(user);
                    if (b) {
                        resultAddOneUser.setCode(Const.SUCCESS);
                        resultAddOneUser.setReason(Const.SUCCESSREASONADD);
                        resultAddOneUser.setUserId(userId);
                        jsonResult = JSON.toJSONString(resultAddOneUser);
                        response.getWriter().write(jsonResult);
                        response.getWriter().close();
                    } else {
                        resultAddOneUser.setCode(Const.FAILURE);
                        resultAddOneUser.setReason(Const.FAILUREREASONADD);
                        resultAddOneUser.setUserId(-1);
                        jsonResult = JSON.toJSONString(resultAddOneUser);
                        response.getWriter().write(jsonResult);
                        response.getWriter().close();
                    }
                } else {
                    resultAddOneUser.setCode(Const.FAILURE);
                    resultAddOneUser.setReason(Const.CHECKED);
                    resultAddOneUser.setUserId(-1);
                    jsonResult = JSON.toJSONString(resultAddOneUser);
                    response.getWriter().write(jsonResult);
                    response.getWriter().close();
                }
            }
        } else {
            resultAddOneUser.setCode(Const.FAILURE);
            resultAddOneUser.setReason(Const.FAILUREREASONUNLOGIN);
            resultAddOneUser.setUserId(-1);
            jsonResult = JSON.toJSONString(resultAddOneUser);
            response.getWriter().write(jsonResult);
            response.getWriter().close();
        }
    }

}
