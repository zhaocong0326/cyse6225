package com.csye6225.spring2020.courseservice.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "announcement")

public class Announcement {
    private String id;
    private String announcementId;
    private String announcementContent;
    private String boardId;
    private String courseId;

    public Announcement() {

    }

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBIndexRangeKey(globalSecondaryIndexName = "AnnouncementId-index", attributeName = "announcementId")
    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    @DynamoDBAttribute(attributeName = "announcementContent")
    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announceContent) {
        this.announcementContent = announceContent;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "AnnouncementId-index", attributeName = "boardId")
    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    @DynamoDBAttribute(attributeName = "courseId")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @DynamoDBIgnore
    @Override
    public String toString() {
        return "announcementId=" + getAnnouncementId() + ",AnnouncementContent=" + getAnnouncementContent() + ",boardId=" + getBoardId();
    }
}
