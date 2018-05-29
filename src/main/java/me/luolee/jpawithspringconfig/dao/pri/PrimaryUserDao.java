package me.luolee.jpawithspringconfig.dao.pri;

import me.luolee.jpawithspringconfig.entity.pri.PrimaryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryUserDao extends JpaRepository<PrimaryUser, Long> {

    PrimaryUser findById(Long id);
}
