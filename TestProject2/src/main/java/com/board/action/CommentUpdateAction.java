package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.model.CommentDAO;

public class CommentUpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int num = 0;
		if (request.getParameter("num") != null){
			num = Integer.parseInt(request.getParameter("num"));
		}
		int commentID = 0;
		if (request.getParameter("commentID") != null){
			commentID = Integer.parseInt(request.getParameter("commentID"));
		}
		CommentDAO commentDAO = new CommentDAO();
		String commentText = commentDAO.getUpdateComment(commentID);
		
		request.setAttribute("num", num);
		request.setAttribute("commentID", commentID);
		request.setAttribute("commentText", commentText);
		
		return "/board/commentUpdate.jsp";
	}

}
