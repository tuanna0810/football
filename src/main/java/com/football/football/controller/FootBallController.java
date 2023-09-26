package com.football.football.controller;


import com.football.football.dto.TeamDTO;
import com.football.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
public class FootBallController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/add")
    public ResponseEntity<String> addTeam(@RequestBody() TeamDTO teamDTO){
        try {
            teamService.save(teamDTO);
            return ResponseEntity.ok("Add new team success");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteTeam(@RequestParam("teamId") Long teamId){
        teamService.delete(teamId);
        return ResponseEntity.ok("Delete team success");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateTeam(@RequestParam("teamId") Long teamId,
                                             @RequestBody TeamDTO teamDTO){
        teamService.update(teamId,teamDTO);
        return ResponseEntity.ok("Update team success");
    }

    @GetMapping("/get")
    public ResponseEntity getTeam(){
        return ResponseEntity.ok()
                .body(teamService.getAllTeam());
    }

    @PostMapping("/makegroup")
    public ResponseEntity makeGroup(){
        try {
            return ResponseEntity.ok()
                    .body(teamService.makeGroup());
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
