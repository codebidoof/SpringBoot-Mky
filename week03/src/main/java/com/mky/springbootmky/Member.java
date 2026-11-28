package com.mky.springbootmky;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Member DAO
@Getter
@Entity // 1. 엔티티로 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 2. 기본 생성자
public class Member {

    @Id // 3. id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false) // 5. name이라는 not null 컬럼과 매핑
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public void changeName(String name) {
        this.name = name;
    }

}

