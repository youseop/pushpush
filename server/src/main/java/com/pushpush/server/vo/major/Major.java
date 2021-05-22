package com.pushpush.server.vo.major;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name="major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long major_idx;

    @Column(nullable = false)
    private String major;

    @Builder
    public Major(String major){
        this.major = major;
    }
}
