package com.zking.ssm.meeting.service;

import com.zking.ssm.meeting.model.Meeting;
import com.zking.ssm.util.PageBean;

import java.util.List;

public interface IMeetingService {
    int insert(Meeting record);



    List<Meeting> queryMeeting(Meeting meeting,PageBean pageBean);
}