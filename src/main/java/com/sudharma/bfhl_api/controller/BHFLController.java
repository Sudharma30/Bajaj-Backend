package com.sudharma.bfhl_api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/bfhl")
public class BHFLController {

    @GetMapping
    public Map<String, Object> getOperationCode(){
        Map<String, Object> response = new HashMap<>();
        response.put("operation_code", 1);
        return response;
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Map<String, Object> handleData(@RequestBody Map<String, Object> requestData) {
        Map<String, Object> response = new HashMap<>();

        // Extracting the data array from the request
        List<String> data = (List<String>) requestData.get("data");
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        String highestLowercaseAlphabet = "";

        // Processing the data
        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (item.matches("[a-z]") && item.compareTo(highestLowercaseAlphabet) > 0) {
                    highestLowercaseAlphabet = item;
                }
            }
        }
        
        response.put("is_success", true);
        response.put("user_id", "sudharma_warune_30032003");
        response.put("email", "sudharama.warune2021@vitstudent.ac.in"); 
        response.put("roll_number", "21BCE2057"); 
        response.put("numbers", numbers);
        response.put("alphabets", alphabets);
        response.put("highest_lowercase_alphabet", highestLowercaseAlphabet.isEmpty() ? new ArrayList<>() : List.of(highestLowercaseAlphabet));

        return response;
    }
}
