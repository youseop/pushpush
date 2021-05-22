package com.pushpush.server.web.major;

import com.pushpush.server.vo.major.Major;
import com.pushpush.server.vo.major.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService {

    private final MajorRepository majorRepository;

    @Transactional
    public List<Major> getRanking(){
        List<Major> temp = majorRepository.findAll();
        System.out.println(temp);
        List<Major> majorList = majorRepository.findByOrderByPointDesc();
        System.out.println(majorList);
        return majorList;
    }

    @Transactional
    public void updateRanking(Integer point, Long major_idx){
        Integer presentPoint = this.getPoint(major_idx) + point;
        majorRepository.updatePoint(presentPoint, major_idx);
    }

    @Transactional
    public Integer getPoint(Long major_idx){
        return majorRepository.findById(major_idx).get().getPoint();
    }
}
