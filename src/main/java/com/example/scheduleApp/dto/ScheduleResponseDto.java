package com.example.scheduleApp.dto;

import java.time.LocalDateTime;

public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime updatedAt;

    public ScheduleResponseDto(Long id, String title, String author, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.updatedAt = updatedAt;
    }
}
