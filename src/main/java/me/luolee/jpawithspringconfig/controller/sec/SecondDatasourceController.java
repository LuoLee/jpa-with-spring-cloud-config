package me.luolee.jpawithspringconfig.controller.sec;

import me.luolee.jpawithspringconfig.dao.sec.SecondUserDao;
import me.luolee.jpawithspringconfig.entity.sec.SecondUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/second")
@RestController
public class SecondDatasourceController {

    private static final Logger logger = LoggerFactory.getLogger(SecondDatasourceController.class);

    @Autowired
    private SecondUserDao userDao;

    @GetMapping("/{id}")
    public ResponseEntity<SecondUser> fetchUserById(@PathVariable String id) {
        SecondUser user = userDao.findById(Long.parseLong(id));
        return ResponseEntity.ok(user);
    }
}
