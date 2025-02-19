package com.mycompany.testapi.repository;

import com.mycompany.testapi.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    @Query("SELECT c FROM Comment c WHERE c.documentid.id = :documentId")
    List<Comment> findByDocumentId(@Param("documentId") String documentId);
}
