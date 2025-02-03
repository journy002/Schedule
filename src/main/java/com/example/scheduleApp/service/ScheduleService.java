package com.example.scheduleApp.service;

import com.example.scheduleApp.dto.ScheduleRequestDto;
import com.example.scheduleApp.dto.ScheduleResponseDto;
import com.example.scheduleApp.entity.Schedule;
import com.example.scheduleApp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public void createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setTitle(requestDto.getTitle());
        schedule.setAuthor(requestDto.getAuthor());
        schedule.setPassword(requestDto.getPassword());
        scheduleRepository.save(schedule);
    }

    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(s -> new ScheduleResponseDto(s.getId(), s.getTitle(), s.getAuthor(), s.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getAuthor(), schedule.getUpdatedAt());
    }

}
