package edu.du.chap17.service;

import edu.du.chap17.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;


@Service
public class DeleteArticleService {

	@Autowired
	ArticleDao articleDao;

	public void deleteArticle(DeleteRequest deleteRequest)
            throws ArticleNotFoundException, InvalidPasswordException, SQLException {
			ArticleCheckHelper checkHelper = new ArticleCheckHelper();
			checkHelper.checkExistsAndPassword(deleteRequest
					.getArticleId(), deleteRequest.getPassword());

			articleDao.delete(deleteRequest.getArticleId());
	}
}
