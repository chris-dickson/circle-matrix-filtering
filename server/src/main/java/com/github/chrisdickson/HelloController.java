package com.github.chrisdickson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class HelloController {
  @Value("classpath:version.txt")
  private Resource version;

  @GetMapping
  public ResponseEntity<String> hello() throws IOException {
    final String versionContents = new String(version.getInputStream().readAllBytes());
    return ResponseEntity.ok(versionContents);
  }
}
