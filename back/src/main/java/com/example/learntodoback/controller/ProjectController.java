package com.example.learntodoback.controller;

import com.example.learntodoback.dto.ProjectDto;
import com.example.learntodoback.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody ProjectDto projectDto) {
        ProjectDto result = projectService.createProject(projectDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<?> getProjectsForCurrentUser() {
        List<ProjectDto> projectDtos = projectService.getProjectsForCurrentUser();
        return ResponseEntity.ok(projectDtos);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable Long projectId) {
        ProjectDto result = projectService.getProjectById(projectId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }
}