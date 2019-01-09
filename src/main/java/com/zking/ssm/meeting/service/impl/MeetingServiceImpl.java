package com.zking.ssm.meeting.service.impl;

import com.zking.ssm.meeting.mapper.MeetingMapper;
import com.zking.ssm.meeting.model.Meeting;
import com.zking.ssm.meeting.service.IMeetingService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeetingServiceImpl implements IMeetingService {

    @Autowired
    private MeetingMapper meetingMapper;

    @Override
    public int insert(Meeting record) {
        return meetingMapper.insert(record);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Meeting> queryMeeting(Meeting meeting, PageBean pageBean) {
        return meetingMapper.queryMeeting(meeting);
    }
}
