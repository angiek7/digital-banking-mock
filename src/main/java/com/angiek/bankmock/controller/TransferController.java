package com.angiek.bankmock.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api")
public class TransferController {
  record Transfer(String from, String to, double amount){}
  private final List<Transfer> ledger = new ArrayList<>();
  @PostMapping("/transfer")
  public Map<String, Object> transfer(@RequestBody Transfer t){
    ledger.add(t);
    return Map.of("status","ok","totalTransfers", ledger.size());
  }
  @GetMapping("/transfers")
  public List<Transfer> transfers(){ return ledger; }
}
