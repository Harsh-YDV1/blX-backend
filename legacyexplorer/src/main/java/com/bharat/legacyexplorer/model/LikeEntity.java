package com.bharat.legacyexplorer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemType;
    private Long itemId;
    private String userId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
