package com.funds4good.Repository;

import com.funds4good.Models.BookMarkMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface BookMarkMapRepo extends JpaRepository<BookMarkMap, Long> {
    BookMarkMap findByUserIdAndPostId(String userId, String postId);

    boolean existsByUserIdAndPostId(String userId, String postId);

    List<BookMarkMap> findByUserId(String userId);

    @Modifying
    @Transactional
    void deleteByUserIdAndPostId(String userId, String postId);
}
