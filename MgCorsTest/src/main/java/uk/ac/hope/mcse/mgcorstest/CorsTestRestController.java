package uk.ac.hope.mcse.mgcorstest;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class CorsTestRestController {

    private String message = "Hello";

    // Endpoint that returns the current time
    @GetMapping("/time")
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Current Time: " + now.format(formatter);
    }

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

    @PostMapping("/new")
    public String setMessage(@RequestBody String message) {
        this.message = message; // Local variable
        return "OK" + message;
    }



}