package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/11 20:17
 * @description：
 * @modified By：
 */
@Component
public class StudentClientFallbackFactory implements FallbackFactory<StudentClientService> {


    @Override
    public StudentClientService create(Throwable throwable) {
        return new StudentClientService() {
            @Override
            public List<Industry> queryIndustry() {
                return null;
            }

            @Override
            public List<Industry> queryIndustryLikeIndustry(String industry) {
                return null;
            }

            @Override
            public PageInfo<Map<String, Object>> queryJobPost(int nextPage) {
                return null;
            }

            @Override
            public JobPost queryJobPostByJobUUID(String jobUUID) {
                return null;
            }

            @Override
            public PageInfo<Map<String, Object>> queryJobPostByIndustryID(int industryID, int nextPage) {
                return null;
            }

            @Override
            public PageInfo<Map<String, Object>> queryJobPostLikePostName(String postName, int nextPage) {
                return null;
            }

            @Override
            public ClassInfo queryByClassUUID(String classUUID) {
                ClassInfo classInfo = new ClassInfo();
                classInfo.setClassName("出错");
                return classInfo;
            }

            @Override
            public ClassSchedule getClassScheduleByClassUUID(String classUUID) {
                return null;
            }

            @Override
            public PageInfo<Map<String, Object>> queryPostByTabName(int tabID,int nextPage) {
                return null;
            }

            @Override
            public PageInfo<Map<String, Object>> getPostList(int nextPage) {
                return null;
            }

            @Override
            public String insertPost(Post post) {
                return null;
            }

            @Override
            public Map<String, Object> getPostByPostUUID(String postUUID) {
                return null;
            }

            @Override
            public Map<String, Object> getPostByPostUUIDForPar(String postUUID) {
                return null;
            }

            @Override
            public List<Map<String, Object>> postDiscussByPostUUID(String postUUID) {
                return null;
            }

            @Override
            public String insertPostDiscuss(PostDiscuss postDiscuss) {
                return null;
            }

            @Override
            public boolean delPostDiscuss(String discussUUID) {
                return false;
            }

            @Override
            public List<PostTab> getPostTabList() {
                return null;
            }

            @Override
            public boolean upHeadImg(MultipartFile file, String stuUUID) {
                return false;
            }

            @Override
            public List<Map<String, Object>> queryStudentListByClassUUID(String classUUID) {
                return null;
            }

            @Override
            public Map<String, Object> queryByStuUUID(String stuUUID) {
                return null;
            }

            @Override
            public Map<String, Object> login(Student student) {
                return null;
            }

            @Override
            public List<StudentScore> queryScoreListByStuUUID(String semester, String stuUUID) {
                return null;
            }

            @Override
            public boolean registerCode(String mobile) {
                return false;
            }

            @Override
            public String login(String code) {
                return null;
            }
        };
    }
}
