package edu.du.chap17;

import edu.du.chap17.model.ArticleListModel;
import edu.du.chap17.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    ListArticleService listSerivce;
    @Autowired
    ReadArticleService readSerivce;
    @Autowired
    WriteArticleService writeSerivce;

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request) {
        String pageNumberString = request.getParameter("p");
        int pageNumber = 1;
        if (pageNumberString != null && pageNumberString.length() > 0) {
            pageNumber = Integer.parseInt(pageNumberString);
        }
        ArticleListModel articleListModel = listSerivce.getArticleList(pageNumber);
        model.addAttribute("listModel", articleListModel);

        if (articleListModel.getTotalPageCount() > 0) {
            int beginPageNumber =
                    (articleListModel.getRequestPage() - 1) / 10 * 10 + 1;
            int endPageNumber = beginPageNumber + 9;
            if (endPageNumber > articleListModel.getTotalPageCount()) {
                endPageNumber = articleListModel.getTotalPageCount();
            }
            model.addAttribute("beginPage", beginPageNumber);
            model.addAttribute("endPage", endPageNumber);
        }
        return "list_view";
    }

    @GetMapping("/read")
    public String read(Model model, HttpServletRequest request) {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        String viewPage = null;
        try {
            model.addAttribute("article", readSerivce.readArticle(articleId));

            viewPage = "/read_view.jsp";
        } catch (ArticleNotFoundException e) {
            viewPage = "/article_not_found.jsp";
        }
        return "read_view";
    }

    @GetMapping("/writeForm")
    public String writeForm(Model model) {
        return "writeForm";
    }

    // WritingRequest 사용해서 받아와서 수정해보기
    @PostMapping("/write")
    public String write(Model model,HttpServletRequest request) {
        WritingRequest Wrequest= new WritingRequest(request.getParameter("title"),
                request.getParameter("writerName"),
                request.getParameter("content"),
                request.getParameter("content"));
        try {
            writeSerivce.write(Wrequest);
        } catch (IdGenerationFailedException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/list";
    }

    @GetMapping("/delete_form")
    public String deleteForm(Model model, HttpServletRequest request) {
        request.getParameter("aritcleId");
        return "delete_form";
    }
}
