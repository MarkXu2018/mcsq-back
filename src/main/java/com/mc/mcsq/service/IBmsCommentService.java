package com.mc.mcsq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.mcsq.model.dto.CommentDTO;
import com.mc.mcsq.model.entity.BmsComment;
import com.mc.mcsq.model.entity.UmsUser;
import com.mc.mcsq.model.vo.CommentVO;

import java.util.List;


public interface IBmsCommentService extends IService<BmsComment> {
    /**
     *
     *
     * @param topicid
     * @return {@link BmsComment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    BmsComment create(CommentDTO dto, UmsUser principal);
}
