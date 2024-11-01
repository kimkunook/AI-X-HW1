package com.ai_x.hw1.controller;

import com.ai_x.hw1.dto.UpdateCountDTO;
import com.ai_x.hw1.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    private CountService countService;

    @Autowired
    public CountController(CountService countService) {
        this.countService = countService;
    }

    // GET /count
    // 현재 DB의 count 값 조회 End point
    @GetMapping("/count")
    public ResponseEntity<?> getCount() {
        try{
            int result = countService.getCount();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("문제 발생");
        }
    }

    // Post /count
    // 프론트의 count 값을 받아서 저장
    @PostMapping("/count")
    public ResponseEntity<?> setCount(@RequestBody UpdateCountDTO updateCountDTO) {
        try{
            countService.setCount(updateCountDTO.getCount());
            return ResponseEntity.status(HttpStatus.OK).body("정상 처리");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("문제 발생");
        }
    }
}
