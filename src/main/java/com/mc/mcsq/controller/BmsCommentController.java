package com.mc.mcsq.controller;

import com.mc.mcsq.common.api.ApiResult;
import com.mc.mcsq.model.dto.CommentDTO;
import com.mc.mcsq.model.entity.BmsComment;
import com.mc.mcsq.model.entity.UmsUser;
import com.mc.mcsq.model.vo.CommentVO;
import com.mc.mcsq.service.IBmsCommentService;
import com.mc.mcsq.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.mc.mcsq.jwt.JwtUtil.USER_NAME;


@RestController
@RequestMapping("/comment")
public class BmsCommentController extends BaseController {

    @Resource
    private IBmsCommentService bmsCommentService;
    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid", defaultValue = "1") String topicid) {
        List<CommentVO> lstBmsComment = bmsCommentService.getCommentsByTopicID(topicid);
        return ApiResult.success(lstBmsComment);
    }
    @PostMapping("/add_comment")
    public ApiResult<BmsComment> add_comment(@RequestHeader(value = USER_NAME) String userName,
                                             @RequestBody CommentDTO dto) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsComment comment = bmsCommentService.create(dto, user);
        return ApiResult.success(comment);
    }
}
