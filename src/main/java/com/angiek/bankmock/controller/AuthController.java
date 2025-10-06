package com.angiek.bankmock.controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api")
public class AuthController {
  @PostMapping("/login")
  public Map<String, Object> login(@RequestBody Map<String, String> body){
    boolean ok = "demo@bank.com".equals(body.get("email")) && "demo123".equals(body.get("password"));
    return Map.of("ok", ok, "token", ok ? "demo-token" : "");
  }
}
