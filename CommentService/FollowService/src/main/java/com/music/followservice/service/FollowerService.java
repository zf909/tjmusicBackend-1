package com.music.followservice.service;




import com.music.followservice.model.FollowerEntity;
import com.music.followservice.model.User;
import com.music.followservice.repository.FollowerRepository;
import com.music.followservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service

public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;
    @Autowired
    private UserRepository userRepository;

    public List<FollowerEntity> getAllfansByfocusId(Integer focusId) {
        Optional<List<FollowerEntity>> followOptional = followerRepository.findAllByfocusId(focusId);
        if (followOptional.isEmpty()) {
            throw new IllegalStateException("该用户没有关注任何人");
        } else {
            return followOptional.get();
        }
    }

    public List<FollowerEntity> getAllfocusByfansId(Integer fansId) {
        Optional<List<FollowerEntity>> studentsOptional = followerRepository.findAllByfansId(fansId);
        if (studentsOptional.isEmpty()) {
            throw new IllegalStateException("没有用户关注该用户");
        } else {
            return studentsOptional.get();
        }
    }

    public FollowerEntity addfollow(FollowerEntity followerEntity)  {
        Integer FocusId = followerEntity.getFocusId();
        Integer FansId = followerEntity.getFansId();
        User FocusOptional = userRepository.findUserByUserId(FocusId);
        User FansOptional = userRepository.findUserByUserId(FansId);
        Optional<FollowerEntity> followerOptional = followerRepository.findById(FocusId,FansId);
        if(FocusOptional==null){
            throw new IllegalStateException("ID为 " + FocusId+ " 的用户不存在！");
    } else if (FansOptional==null) {
        throw new IllegalStateException("ID为" + FansId + " 的用户不存在！");
    } else if (followerOptional.isPresent()) {
        throw new IllegalStateException("您已经关注该用户！"+FocusId+" "+FansId);
    } else {
            return followerRepository.save(followerEntity);
//            JSONObject json = new JSONObject();
//            json.put("status", 200);
//            json.put("message", "新增关注成功");
//     //       throw new IllegalStateException("关注成功");
//            System.out.print(json);
//            return json;
        }
    }
    public boolean removefollow(Integer focusId, Integer fansId) {
        boolean focusExists = userRepository.existsById(focusId);
        boolean fansExists = userRepository.existsById(fansId);
        Optional<FollowerEntity> followerExists = followerRepository.findById(focusId,fansId);
        System.out.print(focusExists+" "+fansExists);
        if (!focusExists) {
            return false;
        } else if (!fansExists) {
            return false;
        }
        else if (!followerExists.isPresent()) {
            return false;
        } else {
            followerRepository.remove(focusId, fansId);
//            JSONObject json = new JSONObject();
//            json.put("status", 200);
//            json.put("message", "删除成功");

            return true;
        }
    }
//    public JSONObject checkExist(Integer focusId, Integer fansId) throws JSONException {
//
//        Optional<FollowerEntity> takesTemp = followerRepository.findById(focusId,fansId);
//        if (takesTemp.isPresent())
//        {
//            JSONObject json = new JSONObject();
//            json.put("status", 000);
//            json.put("message", "关注关系存在");
//            json.put("boolean",true);
//            return json;
//        }
//        JSONObject json = new JSONObject();
//        json.put("status", 001);
//        json.put("message", "关注关系不存在");
//        json.put("boolean",false);
//        return json;
//    }
}
