package com.ai_x.hw1.service;

import com.ai_x.hw1.domain.Count;
import com.ai_x.hw1.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountService {
    private CountRepository countRepository;

    @Autowired
    public CountService(CountRepository countRepository) {
        this.countRepository = countRepository;
    }

    /**
     * Count 값 변경 메서드
     * 최초 데이터가 없으면 생성 후 진행, 기존 데이터가 있는 경우 변경
     * @param count 변경된 count 값
     */
    public void setCount(int count) {
        Optional<Count> byId = countRepository.findById(1);
        if(byId.isEmpty()){
            Count createCount = new Count();
            createCount.setUid(1);
            createCount.setCount(count);
            countRepository.save(createCount);
        }else{
            byId.get().setCount(count);
            countRepository.save(byId.get());
        }
    }

    /**
     * Count 값 조회 메서드
     * @return 조회된 count 반환
     * @throws Exception 조회 과정에서 값이 비어있을 때 발생(원인 모를 오류)
     */
    public int getCount() throws Exception {
        Optional<Count> byId = countRepository.findById(1);
        if(byId.isPresent()){
            return byId.get().getCount();
        }else{
            throw new Exception();
        }
    }
}
