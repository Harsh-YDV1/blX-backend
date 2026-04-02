package com.bharat.legacyexplorer.repository;

import com.bharat.legacyexplorer.model.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    List<LikeEntity> findByItemTypeAndItemId(String itemType, Long itemId);
}
