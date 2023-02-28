package com.project.memo.web;

//import com.project.memo.auth.LoginUser;
//import com.project.memo.auth.dto.SessionUser;
//import com.project.memo.auth.LoginUser;
import com.project.memo.auth.LoginUser;
import com.project.memo.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model,@LoginUser SessionUser user){//Model model,@LoginUser SessionUser user
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
    @GetMapping("/memo/save")
    public String memoSave() {
        return "memo-save";
    } //이런부분은 html리턴 나중에 지울부분
}
