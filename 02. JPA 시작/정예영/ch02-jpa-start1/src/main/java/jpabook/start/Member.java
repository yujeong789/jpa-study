package jpabook.start;

import javax.persistence.*;

@Entity // 이 클래스를 테이블과 매핑한다고 JPA에게 알려주는 어노테이션
@Table(name="MEMBER") // 엔티티 클래스에 매핑할 테이블 정보를 알려주는 어노테이션. 생략 시 엔티티 이름을 테이블 이름으로 매핑
public class Member {

    @Id // 엔티티 클래스의 필드를 테이블의 primary key에 매핑. 식별자 필드.
    @Column(name = "ID") // 필드를 컬럼에 매핑하기 위한 어노테이션
    private String id;

    @Column(name = "NAME")
    private String username;

    private Integer age; // 매핑 어노테이션을 생략하면 필드명을 사용해서 컬럼명으로 매핑. 대소문자를 구분하는 데이터베이스를 사용하는 경우 @Column (name="AGE") 와 같이 명시적으로 매핑해야함.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
