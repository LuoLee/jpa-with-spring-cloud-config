package me.luolee.jpawithspringconfig.dao.sec;

import me.luolee.jpawithspringconfig.entity.sec.SecondUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondUserDao extends JpaRepository<SecondUser, Long> {

    SecondUser findById(Long id);
}
