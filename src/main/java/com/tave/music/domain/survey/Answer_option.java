package com.tave.music.domain.survey;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Answer_option{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_option_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    //옵션 내용
    private String content;


    public void setQuestion(Question question) {
        this.question = question;
    }

    //==생성메서드==//
    public static Answer_option createAnswerOption(String content) {
        Answer_option answer_option = new Answer_option();
        answer_option.content = content;

        return answer_option;

    }


}
