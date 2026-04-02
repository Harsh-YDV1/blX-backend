package com.bharat.legacyexplorer.controller;

import com.bharat.legacyexplorer.model.CommentEntity;
import com.bharat.legacyexplorer.model.LikeEntity;
import com.bharat.legacyexplorer.service.EngagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EngagementController {
    private final EngagementService engagementService;

    public EngagementController(EngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @GetMapping("/likes")
    public List<LikeEntity> getLikes(@RequestParam(required = false) String itemType,
                                     @RequestParam(required = false) Long itemId) {
        return engagementService.getLikes(itemType, itemId);
    }

    @PostMapping("/likes")
    public LikeEntity addLike(@RequestBody LikeEntity like) {
        return engagementService.addLike(like);
    }

    @DeleteMapping("/likes/{id}")
    public void deleteLike(@PathVariable Long id) {
        engagementService.deleteLike(id);
    }

    @GetMapping("/comments")
    public List<CommentEntity> getComments(@RequestParam(required = false) String itemType,
                                           @RequestParam(required = false) Long itemId) {
        return engagementService.getComments(itemType, itemId);
    }

    @PostMapping("/comments")
    public CommentEntity addComment(@RequestBody CommentEntity comment) {
        return engagementService.addComment(comment);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        engagementService.deleteComment(id);
    }
}
