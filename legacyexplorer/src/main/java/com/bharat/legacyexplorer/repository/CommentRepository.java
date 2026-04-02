package com.bharat.legacyexplorer.repository;

import com.bharat.legacyexplorer.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByItemTypeAndItemId(String itemType, Long itemId);
}
