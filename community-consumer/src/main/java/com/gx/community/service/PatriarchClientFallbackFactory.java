package com.gx.community.service;

import com.github.pagehelper.PageInfo;
import com.gx.community.pojo.JobPost;
import com.gx.community.pojo.Parent;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/14 15:37
 * @description：
 * @modified By：
 */
@Component
public class PatriarchClientFallbackFactory implements FallbackFactory<PatriarchClientService> {
    @Override
    public PatriarchClientService create(Throwable throwable) {
        return new PatriarchClientService() {
            @Override
            public boolean addPost(JobPost jobPost) {
                return false;
            }

            @Override
            public boolean deleteJobPostByJobUUID(String jobUUID) {
                return false;
            }

            @Override
            public PageInfo<Map<String, Object>> queryJobPostByParUUID(String parUUID, int nextPage) {
                return null;
            }

            @Override
            public Map<String, Object> login(Parent formData) {
                return null;
            }

            @Override
            public Boolean updateDefaultPassword(Parent formData) {
                return null;
            }

            @Override
            public List<Map<String, Object>> queryStudentListByParUUID(String parUUID) {
                return null;
            }

            @Override
            public Map<String, Object> queryStudentScoreByStuUUID(String stuUUID) {
                return null;
            }
        };
    }
}
