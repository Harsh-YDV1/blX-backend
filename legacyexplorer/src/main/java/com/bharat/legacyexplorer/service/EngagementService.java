package com.bharat.legacyexplorer.service;

import com.bharat.legacyexplorer.model.CommentEntity;
import com.bharat.legacyexplorer.model.LikeEntity;
import com.bharat.legacyexplorer.repository.CommentRepository;
import com.bharat.legacyexplorer.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngagementService {
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    public EngagementService(LikeRepository likeRepository, CommentRepository commentRepository) {
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
    }

    public List<LikeEntity> getLikes(String itemType, Long itemId) {
        if (itemType != null && itemId != null) {
            return likeRepository.findByItemTypeAndItemId(itemType, itemId);
        }
        return likeRepository.findAll();
    }

    public LikeEntity addLike(LikeEntity like) { return likeRepository.save(like); }
    public void deleteLike(Long id) { likeRepository.deleteById(id); }

    public List<CommentEntity> getComments(String itemType, Long itemId) {
        if (itemType != null && itemId != null) {
            return commentRepository.findByItemTypeAndItemId(itemType, itemId);
        }
        return commentRepository.findAll();
    }

    public CommentEntity addComment(CommentEntity comment) { return commentRepository.save(comment); }
    public void deleteComment(Long id) { commentRepository.deleteById(id); }
}
