package com.sbb_2.Question;

import com.sbb_2.Answer.Answer;
import com.sbb_2.User.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;


    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    //mappedBy는 참조 엔티티의 속성명을 정의
    //질문 삭제되면 답변도 함께 삭제
    @OneToMany(mappedBy="question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> voter;

}
