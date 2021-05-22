package com.pushpush.server.controller;

import com.pushpush.server.vo.major.Major;
import com.pushpush.server.web.jwt.JwtUserDetailsService;
import com.pushpush.server.web.major.RankingDto;
import com.pushpush.server.web.major.RankingDtoWrapper;
import com.pushpush.server.web.major.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MajorController {

    private final MajorService majorService;
    private final JwtUserDetailsService userService;

    @GetMapping("/api/rank/")
    public ResponseEntity<?> getRank(){
        try{
            List<Major> majorList = majorService.getRanking();
            System.out.println(majorList);
            return new ResponseEntity<>(majorList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/rank/update")
    public String updateRank(@RequestBody RankingDtoWrapper ranking_list){
        try{
            List<RankingDto> rankingList = ranking_list.getData();
            for(RankingDto rank : rankingList){
                majorService.updateRanking(rank.getPoint(), userService.getUser(rank.getUsername()).getMajor_idx());
            }

            return "OK";
        } catch (Exception e){
            return "not OK";
        }
    }
}
