package qwikk.mazeSolver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qwikk.mazeSolver.service.MazeService;

@RestController
@RequestMapping("/maze")
public class MazeController {
    @Autowired
    private MazeService mazeService;

    @PostMapping("/solve")
    public String solve(@RequestBody String mazeString) {
        return mazeService.getMaze(mazeString);
    }
}
