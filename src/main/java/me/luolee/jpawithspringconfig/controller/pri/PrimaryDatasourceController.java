package me.luolee.jpawithspringconfig.controller.pri;

import me.luolee.jpawithspringconfig.dao.pri.PrimaryUserDao;
import me.luolee.jpawithspringconfig.entity.pri.PrimaryUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primary")
public class PrimaryDatasourceController {

    private static final Logger logger = LoggerFactory.getLogger(PrimaryDatasourceController.class);

    @Autowired
    private PrimaryUserDao userDao;

    @GetMapping("/{id}")
    public ResponseEntity<PrimaryUser> fetchUserById(@PathVariable String id) {
        PrimaryUser user = userDao.findById(Long.parseLong(id));
        return ResponseEntity.ok(user);
    }

}
