package com.bookIt.controller.login;

import com.bookIt.datahelper.LoginDataHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity handleLogin(@RequestBody LoginDataHelper loginDataHelper){
        return new ResponseEntity(HttpStatus.OK);
    }
}
