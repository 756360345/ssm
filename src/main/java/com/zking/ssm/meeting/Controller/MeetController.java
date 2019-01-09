package com.zking.ssm.meeting.Controller;

import com.zking.ssm.meeting.model.Meeting;
import com.zking.ssm.meeting.service.IMeetingService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Meeting")
public class MeetController {

    @Autowired
    private IMeetingService meetingService;

    @RequestMapping("/MeetingList")
    public String toqueryMeeting(){
        return "/Meeting/MeetingList";
    }

    @RequestMapping("/queryMeeting")
    public List<Meeting> queryMeeting(Meeting meeting, HttpServletRequest req){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
        List<Meeting> meetings = meetingService.queryMeeting(meeting, pageBean);
        return meetings;

    }
}
