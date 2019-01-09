package com.zking.ssm.meeting.mapper;

import com.zking.ssm.meeting.model.Meeting;

import java.util.List;

public interface MeetingMapper {
    int insert(Meeting record);

    int insertSelective(Meeting record);

    List<Meeting> queryMeeting(Meeting meeting);
}